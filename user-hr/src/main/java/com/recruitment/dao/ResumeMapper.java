package com.recruitment.dao;

import com.recruitment.domain.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Author 王凯
 * Date 2019/11/14
 * Time 20:31
 */
@Mapper
public interface ResumeMapper {
    public Resume selectByUserId(Integer userId);



}
