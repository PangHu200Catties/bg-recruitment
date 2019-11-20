package com.recruitment.controller;

import com.recruitment.domain.Order;
import com.recruitment.domain.PageBean;
import com.recruitment.service.OrderService;
import com.recruitment.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 陈琪文
 * @Date: 2019/11/19 15:38
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    RedisUtils redisUtils;

    @RequestMapping("findByOrderStatusAndUserId/{orderStatus}/{currentPage}/{pagesize}/{userId}")
    PageBean<Order> findByOrderStatusAndUserId(@PathVariable("orderStatus") int orderStatus, @PathVariable("currentPage")int currentpage,
                                         @PathVariable("pagesize")int pagesize,@PathVariable("userId")int userId){
            PageBean<Order> allByOrderStatus = orderService.findByOrderStatusAndUserId(orderStatus, userId, currentpage, pagesize);
            return allByOrderStatus;
    }

    //软删除未支付订单
    @RequestMapping("handleDelete/{orderId}")
    void handleDelete(@PathVariable("orderId") int orderId){
        orderService.handleDelete(orderId);
    }
    //硬删除已支付订单
    @RequestMapping("orderDelete/{orderId}")
    void orderDelete(@PathVariable("orderId") int orderId){
        orderService.orderDelete(orderId);
    }
}
