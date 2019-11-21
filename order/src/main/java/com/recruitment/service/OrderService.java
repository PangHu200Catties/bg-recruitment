package com.recruitment.service;

import com.recruitment.domain.Order;
import com.recruitment.domain.PageBean;

/**
 * @Author: 陈琪文
 * @Date: 2019/11/19 15:39
 */
public interface OrderService {
    PageBean<Order> findByOrderStatusAndUserId(int orderStatus,int userId,int currentPage,int pagesize);

    void handleDelete(int orderId);

    void orderDelete(int orderId);
}
