package com.recruitment.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_pic")
    private String userPic;

    private String realname;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_gender")
    private Integer userGender;
    @Column(name = "user_phone")
    private String userPhone;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_age")
    private Integer userAge;

    private Integer workage;
    @Column(name = "is_vip")
    private Integer isVip;
    @Column(name = "user_liveness")
    private Integer userLiveness;
    @Column(name = "is_hr")
    private Integer isHr;

    private Integer education;
    @Column(name = "work_status")
    private Integer workStatus;


    private String nickName;


    private Integer expectedSalary;

    private String ban;


}