package com.recruitment.service.impl;

import com.recruitment.dao.*;
import com.recruitment.domain.Education;
import com.recruitment.domain.Resume;
import com.recruitment.domain.UserSet;
import com.recruitment.domain.User;
import com.recruitment.service.UserSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.Optional;

/**
 * Author 王凯
 * Date 2019/11/14
 * Time 15:32
 */
@Service
public class UserSetServiceImpl implements UserSetService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private ResumeRepository resumeRepository;
    @Resource
    private EducationMapper educationMapper;
    @Resource
    private ResumeMapper resumeMapper;
    @Override
    public UserSet findAllById(int id) {
        UserSet userSet = new UserSet();
        Optional<User> userOptional = userRepository.findById(id);
        Resume resume = resumeMapper.selectByUserId(id);
        Education education = educationMapper.selectByUserId(id);
        if (userOptional.isPresent()){
            userSet.setUser(userOptional.get());
        }
        if (resume!=null){
            userSet.setResume(resume);
        }
        if (education!=null){
            userSet.setEducation(education);
        }

        return userSet;
    }

    @Override
    public Resume findHide(int id) {
        return resumeMapper.selectByUserId(id);
    }

    @Override
    public void updateHide(UserSet userSet) {
        User user = userRepository.saveAndFlush(userSet.getUser());
        Resume resume = userSet.getResume();
        if (resume.getHide()!=0){
            resume.setHide(0);
            Resume resume1 = resumeRepository.saveAndFlush(resume);
            if (resume1!=null) {
                userSet.setResume(resume1);
            }
        }else {
            resume.setHide(1);
            Resume resume1 = resumeRepository.saveAndFlush(resume);
            if (resume1!=null) {
                userSet.setResume(resume1);
            }
        }
        Education education = educationRepository.saveAndFlush(userSet.getEducation());
        if (user!=null){
            userSet.setUser(user);
        }
     if (education!=null){
         userSet.setEducation(education);
     }

    }

    @Override
    public void updateResume(UserSet userSet) {
        User user = userRepository.saveAndFlush(userSet.getUser());
        Resume resume = resumeRepository.saveAndFlush(userSet.getResume());
        Education education = educationRepository.saveAndFlush(userSet.getEducation());

        userSet.setUser(user);
        userSet.setResume(resume);
        userSet.setEducation(education);
    }

}
