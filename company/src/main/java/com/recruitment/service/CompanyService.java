package com.recruitment.service;

import com.recruitment.domain.Company;
import com.recruitment.domain.Hr;
import com.recruitment.domain.Position;
import com.recruitment.domain.Welfare;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 张浩
 * @Date: 2019/11/13 16:57
 */
public interface CompanyService {
    //查询公司详细信息方法
    public Company selectCompanyById(Integer id);
    //根据公司id查询公司在招职位
    public Long selectAllPosition(Integer id);
    //根据公司id查询公司福利表
    public Welfare selectWelfareByCompanyId(Integer id);
    //根据公司id查公司一共有多少个在招职位
    public int selectPositionNumByCompanyId(Integer id);
    //根据公司id查公司所有Hr
    public List<Hr> selectHrNumByCompanyId(Integer id);
    //根据职位id查询职位详细信息
    public Position selectPositionById(Integer id);
    //在职位表中根据公司id和职位id查出所对应的Hr
    public Position selectHrByCompanyIdAndAndPositionId(int companyId,int positionId);
    //根据HrId查Hr的详细信息
    public Hr selectHrByHrId(int id);
    //上传公司信息
    public String saveCompany(Company company);
}
