package com.recruitment.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userPic;

    private String realname;

    private String userPassword;

    private Integer userGender;

    private String userPhone;

    private String userEmail;

    private Integer userAge;

    private Integer workage;

    private Integer isVip;

    private Integer userLiveness;

    private Integer isHr;

    private Integer education;

    private Integer workStatus;

    private String nickName;


    private Integer expectedSalary;

    private String info3;


}