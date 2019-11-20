package com.recruitment.dao;

import com.recruitment.domain.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author 王凯
 * Date 2019/11/14
 * Time 15:20
 */
@Repository
public interface ResumeRepository extends JpaRepository<Resume,Integer> {
}
