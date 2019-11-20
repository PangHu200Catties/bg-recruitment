package com.recruitment.dao;

import com.recruitment.domain.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author 王凯
 * Date 2019/11/14
 * Time 15:19
 */
@Repository
public interface EducationRepository extends JpaRepository<Education,Integer> {
}
