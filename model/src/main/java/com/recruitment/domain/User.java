package com.recruitment.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

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

    private String expectedSalary;
//职位
    private String info3;

    private String info2;
}