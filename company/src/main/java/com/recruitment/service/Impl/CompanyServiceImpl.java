package com.recruitment.service.Impl;

import com.recruitment.dao.CompanyRepository;
import com.recruitment.dao.HrRepository;
import com.recruitment.dao.PositionRepository;
import com.recruitment.dao.WelfareRepository;
import com.recruitment.domain.Company;
import com.recruitment.domain.Hr;
import com.recruitment.domain.Position;
import com.recruitment.domain.Welfare;
import com.recruitment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: 张浩
 * @Date: 2019/11/13 17:25
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    WelfareRepository welfareRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    HrRepository hrRepository;

    @Override
    public Company selectCompanyById(Integer id) {
        Optional<Company> byId = companyRepository.findById(id);
        Company company = byId.get();
        return company;

    }

    @Override
    public Long selectAllPosition(Integer id) {
        return null;
    }

    //根据公司id查询公司福利表
    @Override
    public Welfare selectWelfareByCompanyId(Integer id) {
        Optional<Welfare> byId = welfareRepository.findById(id);
        Welfare welfare = byId.get();
        return welfare;
    }

    //根据公司id查公司一共有多少个在招职位
    @Override
    public int selectPositionNumByCompanyId(Integer id) {
        List<Position> byCompanyId = positionRepository.findByCompanyId(id);
        int positionsize = byCompanyId.size();
        return positionsize;
    }


    //根据公司id查公司一共有多少个Hr
    @Override
    public List<Hr> selectHrNumByCompanyId(Integer id) {
        List<Hr> byCompanyId = hrRepository.findByCompanyId(id);
        return byCompanyId;
    }

    //根据职位id查询职位详细信息
    public Position selectPositionById(Integer id){
        Optional<Position> byId = positionRepository.findById(id);
        Position position = byId.get();
        return position;
    }

    @Override
    public Position selectHrByCompanyIdAndAndPositionId(int companyId, int positionId) {
        Position byCompanyIdAndAndPositionId = positionRepository.findByCompanyIdAndAndPositionId(companyId, positionId);
        return byCompanyIdAndAndPositionId;
    }

    @Override
    public Hr selectHrByHrId(int id) {
        Optional<Hr> byId = hrRepository.findById(id);
        Hr hr = byId.get();
        return hr;
    }

    @Override
    public String saveCompany(Company company) {
        companyRepository.saveAndFlush(company);
        return null;
    }
}