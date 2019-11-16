package com.recruitment.dao;

import com.recruitment.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/14
 * @Time: 11:00
 * @description:
 */
public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
