package com.rencruitment.service;


import com.recruitment.domain.Order;

/**
 * Author 张浩
 * Date 2019/10/18
 * Time 14:47
 */
public interface OrderService {
    public void save(Order order);

    public Order findByOrderCode(String orderCode);

    public void saveAndFlush(Order order);
}
