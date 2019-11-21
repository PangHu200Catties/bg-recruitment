package com.recruitment.service.impl;

import com.recruitment.dao.*;
import com.recruitment.domain.*;
import com.recruitment.service.HomepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/13
 * @Time: 16:46
 * @description:
 */
@Service
public class HomepageServiceImpl implements HomepageService {

    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private HrRepository hrRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public List<User> listUser() {
        return null;
    }

    @Override
    public List<CompanySet> listPosition() {
        List<CompanySet> companySets = new ArrayList<>();
        Object o = redisTemplate.opsForValue().get("position");

        if (o != null && !"empty".equals(o)){
            List<CompanySet> sets = (List<CompanySet>) o;
            if (sets.size()>16){
                List<CompanySet> positions = sets.subList(0, 16);
                return sets;
            }else {
                return   sets.subList(0, sets.size());
            }
        }
        List<Position> allPositions = positionRepository.findAll();
        if (allPositions != null){
            for (Position p:allPositions) {
                Optional<Hr> byId = hrRepository.findById(p.getHrId());
                Hr hr = byId.get();
//                userRepository.findByHrID()
                Optional<Company> byId1 = companyRepository.findById(p.getCompanyId());
                Company company = byId1.get();
                Address address = addressRepository.findByCompanyId(company.getCompanyId());

                CompanySet companySet = new CompanySet();
                companySet.setCompany(company);
                companySet.setHr(hr);
                companySet.setPosition(p);
                companySet.setAddress(address);
                companySets.add(companySet);
            }
            redisTemplate.opsForValue().set("position",companySets);
        }else {
            redisTemplate.opsForValue().set("position","empty",30000);
        }
        return companySets;
    }
}
