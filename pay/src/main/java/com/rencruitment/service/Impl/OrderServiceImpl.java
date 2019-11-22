package com.rencruitment.service.Impl;

import com.recruitment.domain.Order;
import com.rencruitment.mapper.OrderRepository;
import com.rencruitment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author: 张浩
 * @Date: 2019/11/18 19:09
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order findByOrderCode(String orderCode) {
        return orderRepository.findByOrderCode(orderCode);
    }

    @Override
    public void saveAndFlush(Order order) {
        orderRepository.saveAndFlush(order);
    }
}
