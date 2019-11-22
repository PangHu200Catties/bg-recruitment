package com.recruitment.dao;

import com.recruitment.domain.Company;
import com.recruitment.domain.Position;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 张浩
 * @Date: 2019/11/13 17:24
 */
@Mapper
public interface PositionMapper {
    public List<Position> findAll();
}
