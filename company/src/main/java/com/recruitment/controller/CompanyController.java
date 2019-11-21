package com.recruitment.controller;

import com.recruitment.domain.Company;
import com.recruitment.domain.Hr;
import com.recruitment.domain.Position;
import com.recruitment.domain.Welfare;
import com.recruitment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author: 张浩
 * @Date: 2019/11/13 16:56
 */
@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;

    //根据id查询公司详细信息
    @RequestMapping("/selectCompanyById/{id}")
    public Company selectCompanyById(@PathVariable("id") int id){
        Company companyinfo = companyService.selectCompanyById(id);
        return companyinfo;
    }

    //根据公司id查询公司福利
    @RequestMapping("/selectWelfareByCompanyId/{id}")
    public Welfare selectWelfareByCompanyId(@PathVariable("id") int id){
        Welfare welfare = companyService.selectWelfareByCompanyId(id);
        return welfare;
    }

    //根据公司id查公司一共有多少个在招职位
    @RequestMapping("selectPositionNumByCompanyId/{id}")
    public int selectPositionNumByCompanyId(@PathVariable("id") int id) {
        int positionnum = companyService.selectPositionNumByCompanyId(id);
//        System.out.println(positionnum+"ppppppppppppppppppppppppppppppppp");
        return positionnum;
    }


    //根据公司id查公司一共有多少个Hr
    @RequestMapping("selectHrNumByCompanyId/{id}")
    public int selectHrNumByCompanyId(@PathVariable("id") int id) {
        List<Hr> hrs = companyService.selectHrNumByCompanyId(id);
        int hrnum = hrs.size();
//        System.out.println(hrnum+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        return hrnum;
    }
    //根据公司id查公司所有Hr信息
    @RequestMapping("selectAllHrByCompanyId/{id}")
    public List<Hr> selectAllHrByCompanyId(@PathVariable("id") int id) {
        List<Hr> hrs = companyService.selectHrNumByCompanyId(id);
//        System.out.println(hrs.get(0).toString()+"++++++++++++++++++++++++++++++++++++++");
        return hrs;
    }


    //根据职位id查询职位详细信息
    @RequestMapping("selectPositionById/{id}")
    public Position selectPositionById(@PathVariable("id") int id){
        Position position = companyService.selectPositionById(id);
        return position;
    }

    //根据公司id和职位id查对应Hr
    @RequestMapping("selectHrByCompanyIdAndPositionId/{companyId}/{positionId}")
    public Hr selectHrByCompanyIdAndPositionId(@PathVariable("companyId") int companyId,@PathVariable("positionId") int positionId){
       //在职位表中根据公司id和职位id查出所对应的Hr
        Position position = companyService.selectHrByCompanyIdAndAndPositionId(companyId, positionId);
        Integer hrId = position.getHrId();
        //再去查Hr库找到Hr的详细信息
        Hr hr = companyService.selectHrByHrId(hrId);
        return hr;
    }

    //上传公司信息
    @RequestMapping("/uploadcompany")
    public String uploadCompany(@RequestBody Company company){
       /* Company companyinfo=new Company();
        companyinfo.setCompanyName(company.getCompanyName());*/
       companyService.saveCompany(company);
       return "上传成功";
    }

}
