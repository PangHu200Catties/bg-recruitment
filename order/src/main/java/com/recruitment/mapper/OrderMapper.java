package com.recruitment.mapper;

import com.recruitment.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 陈琪文
 * @Date: 2019/11/19 20:20
 */
@Mapper
public interface OrderMapper {
    List<Order> findByOrderStatusAndUserId(@Param("orderStatus") int orderStatus, @Param("userId") int userId, @Param("currentPage")int currentPage, @Param("pagesize") int pagesize);
}
