package com.recruitment.dao;

import com.recruitment.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/13
 * @Time: 16:47
 * @description:
 */
public interface PositionRepository extends JpaRepository<Position,Integer> {

}
