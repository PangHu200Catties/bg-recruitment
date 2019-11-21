package com.recruitment.service.impl;

import com.recruitment.domain.Order;
import com.recruitment.domain.PageBean;
import com.recruitment.mapper.OrderJpaRespository;
import com.recruitment.mapper.OrderMapper;
import com.recruitment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @Author: 陈琪文
 * @Date: 2019/11/19 15:50
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Autowired
    private OrderJpaRespository orderJpaRespository;

    @Override
    public PageBean<Order> findByOrderStatusAndUserId(int orderStatus,int userId, int currentPage,int pagesize) {
        List<Order> byOrderStatusAndUserId = orderMapper.findByOrderStatusAndUserId(orderStatus, userId, currentPage-1, pagesize);
        PageBean<Order> pageBean=new PageBean<>();
        pageBean.setList(byOrderStatusAndUserId);
        pageBean.setTotal(byOrderStatusAndUserId.size());
        return pageBean;
    }

    @Override
    public void handleDelete(int orderId) {
        Order byOrderId = orderJpaRespository.findByOrderId(orderId);
        byOrderId.setOrderStatus(0);
        orderJpaRespository.save(byOrderId);
    }

    @Override
    public void orderDelete(int orderId) {
        orderJpaRespository.deleteByOrderId(orderId);
    }

    @Override
    public void doOrder(Order order) {
        order.setOrderStatus(1);
        order.setMoney(96);
        StringBuilder s=new StringBuilder();
        Random random=new Random();
        for(int i=0;i<8;i++) {
            s.append(Integer.valueOf(random.nextInt(10)).toString());
        }
        order.setOrderNumber(s.toString());
        orderJpaRespository.save(order);
    }
}
