package com.recruitment.dao;

import com.recruitment.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/14
 * @Time: 15:19
 * @description:
 */
public interface AddressRepository extends JpaRepository<Address,Integer> {

    Address findByCompanyId(Integer id);
}
