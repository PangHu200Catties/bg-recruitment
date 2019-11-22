package com.recruitment.service;

import com.recruitment.domain.PageBean;

/**
 * @Author: 张浩
 * @Date: 2019/11/18 14:46
 */
public interface PositionService {
    void setAll();
    PageBean getResults(PageBean pageBean);
}
