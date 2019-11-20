package com.recruitment.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "education")
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer educationId;

    private Integer userid;

    private String school;

    private Integer education;

    private String major;

    private Date starttime;

    private Date endtime;

    private String certificate;

    private Integer isFulltime;

    private String experience;

    private String info1;

    private String info2;

    private String info3;


}