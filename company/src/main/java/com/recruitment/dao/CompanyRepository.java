package com.recruitment.dao;

import com.recruitment.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @Author: 张浩
 * @Date: 2019/11/13 17:24
 */
public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
