package com.recruitment.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    private String companyName;

    private String companyDescription;

    private String companyPic;

    private Integer companyPopulation;

    private String companyEmail;

    private Integer companyType;

    private String companyUrl;

    private String info1;

    private String info2;

    private String info3;


}