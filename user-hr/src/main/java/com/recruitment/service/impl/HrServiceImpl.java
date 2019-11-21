package com.recruitment.service.impl;

import com.recruitment.domain.User;
import com.recruitment.mapper.HrMapper;
import com.recruitment.mapper.HrRepository;
import com.recruitment.service.HrService;
import com.recruitment.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Author 贾振乾
 * Date 2019/11/13
 * Time 10:19
 */
@Service
public class HrServiceImpl implements HrService {


    @Resource
    private HrMapper hrMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private HrRepository hrRepository;

    @Override
    public PageBean listAllUser(int hid, int page, int size) {
        // 1.查询redis

        Object pageBean = redisTemplate.opsForValue().get("userPageBean" + hid+page);

        if (!ObjectUtils.isEmpty(pageBean)) {
            return (PageBean) pageBean;
        }
//        2查询数据库

        List<User> userListByPage = hrRepository.findUserListByPage(hid, (page-1)*size, size);
        int userListTotal = hrRepository.findUserListTotal(hid, (page - 1) * size, size);

        PageBean userPageBean = new PageBean();

        userPageBean.setList(userListByPage);
        userPageBean.setTotal(userListTotal);

//      3将从数据库中查询的数据放入redis中
        redisTemplate.opsForValue().set("userPageBean" +hid+ page, userPageBean, 1, TimeUnit.MINUTES);
        return userPageBean;
    }

    @Override
    public void deleteUserByUserid(int uid ,int hid ,int page) {

        hrRepository.deleteById(hid,uid);
        Boolean userPageBean = redisTemplate.delete("userPageBean"+hid+page);
        System.out.println(userPageBean);

    }
}
