package com.recruitment.mapper;

import com.recruitment.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



/**
 * @Author: 陈琪文
 * @Date: 2019/11/19 15:52
 */
@Component
public interface OrderJpaRespository extends JpaRepository<Order,Integer> {

    Order findByOrderId(int orderId);

    void deleteByOrderId(int orderId);
}
