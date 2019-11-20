package com.recruitment.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "resume")
@Data
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resumeId;

    private Integer userId;

    private Integer workage;

    private Integer status;

    private Integer workStatus;

    private String advantage;
    private Integer hide;

    private String info1;

    private String info2;

    private String info3;


}