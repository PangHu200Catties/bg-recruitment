package com.recruitment.service;

import com.recruitment.utils.PageBean;

/**
 * Author 贾振乾
 * Date 2019/11/13
 * Time 10:18
 */

public interface HrService {
    PageBean listAllUser(int hid,int page,int size);

    void deleteUserByUserid(int uid,int hid ,int page);
}
