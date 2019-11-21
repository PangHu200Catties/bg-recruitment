package com.recruitment.dao;

import com.recruitment.domain.Hr;
import com.recruitment.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 张浩
 * @Date: 2019/11/13 17:24
 */
public interface HrRepository extends JpaRepository<Hr,Integer> {
    //根据公司id去查公司对应Hr
    public List<Hr> findByCompanyId(Integer id);

}
