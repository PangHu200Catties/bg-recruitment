package com.recruitment.service;

import com.recruitment.domain.Resume;
import com.recruitment.domain.UserSet;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author 王凯
 * Date 2019/11/14
 * Time 15:29
 */
public interface UserSetService {
    public UserSet findAllById(@PathVariable("id") int id);
    public Resume findHide(@PathVariable("id") int id);

    void updateHide(UserSet userSet);
    void updateResume(UserSet userSet);
}
