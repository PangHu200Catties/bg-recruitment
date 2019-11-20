package com.recruitment.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;

    private Integer companyId;

    private String positionName;

    private String positionType;

    private String positiondeScription;

    private Integer positionNum;

    private Integer educationRequire;

    private Integer startYearRequire;

    private Integer endYearRequire;

    private Date publishTime;

    private Integer lowestSalary;

    private Integer highestSalary;

    private Integer hrId;

    private String info2;

    private String info3;

    private String info1;
}