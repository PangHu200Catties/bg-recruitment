package com.recruitment.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.recruitment.domain.User;
import com.recruitment.service.HrService;
import com.recruitment.service.UserService;
import com.recruitment.utils.PageBean;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Author 贾振乾
 * Date 2019/11/13
 * Time 10:13
 */
@RestController
public class HrController {
    @Resource
    private HrService hrService;
    @Resource
    private UserService userService;

    //    分页查看投递的简历
    @RequestMapping("/hListAll/{hid}/{page}/{size}")
    public PageBean hListAlluser(@PathVariable("hid") int hid,
                                 @PathVariable("page") int page,
                                 @PathVariable("size") int size) {
        System.out.println("====>hid"+hid+",page"+page+",size"+size);
        PageBean userPageBean = hrService.listAllUser(hid,page, size);
        return userPageBean;
    }


    //      删除投递的简历
    @RequestMapping("/deleteUserByUserid/{uid}/{hid}/{page}")
    public String deleteUserByUserid(@PathVariable("uid") int uid,
                                     @PathVariable("hid") int hid,
                                     @PathVariable("page") int page) {
        System.out.println("sss");
        hrService.deleteUserByUserid(uid,hid,page);
        return "成功";
    }

    //      查询个人信息
    @RequestMapping("/findUserById/{uid}")
    public User findUserByUserId(@PathVariable("uid") int uid) {
        return userService.findUserByUserId(uid);
    }

    //  修改个人信息
    @RequestMapping("/updateUser")
    public String findUserByUserId(@RequestBody User user) {

        System.out.println(user.toString());
        return userService.updateUser(user);
    }

    //    测试
    @RequestMapping("/list")
    public String list() {
        System.out.println("成功");
        return "success";
    }
}
