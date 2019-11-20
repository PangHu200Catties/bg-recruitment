package com.recruitment.dao;

import com.recruitment.domain.Education;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author 王凯
 * Date 2019/11/14
 * Time 20:31
 */
@Mapper
public interface EducationMapper {
    public Education selectByUserId(Integer userid);
}
