package com.recruitment.dao;

import com.recruitment.domain.Company;
import com.recruitment.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author: 张浩
 * @Date: 2019/11/13 17:24
 */
public interface PositionRepository extends JpaRepository<Position,Integer> {
    //根据公司id去查公司有多少在招职位
    public List<Position> findByCompanyId(Integer id);
    //在职位表中根据公司id和职位id查出所对应的Hr
    public Position findByCompanyIdAndAndPositionId(int companyId,int positionId);
}
