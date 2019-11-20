package com.recruitment.mapper;

import com.recruitment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author 贾振乾
 * Date 2019/11/13
 * Time 10:37
 */

public interface HrRepository extends JpaRepository<User,Integer> {

    @Query(value = "select * " +
            " from hr_resume h, user u  " +
            " where h.hr_id =?1 and h.user_id = u.user_id  limit ?2 , ?3", nativeQuery=true)
    List<User> findUserListByPage(int hid,int page, int size);

    @Query(value = "select count(*) " +
            " from hr_resume h, user u  " +
            " where h.hr_id =?1 and h.user_id = u.user_id ", nativeQuery=true)
    public int findUserListTotal(int hid, int page, int size);

    @Transactional
    @Modifying
    @Query(value = "delete from hr_resume where hr_id=?1 and user_id =?2",nativeQuery = true)
    void deleteById(int hid,int uid);

}
