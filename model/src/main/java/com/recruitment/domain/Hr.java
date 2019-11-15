package com.recruitment.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "hr")
@Data
public class Hr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hrId;

    private String hrPic;

    private Integer companyId;

    private String hrPosition;

    private Integer isVip;

    private String hrPhone;

    private String info1;

    private String info2;

    private String info3;


}