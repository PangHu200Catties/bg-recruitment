package com.recruitment.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "welfare")
public class Welfare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer welfareId;

    private Integer companyId;

    private String welfare1;

    private String welfare2;

    private String welfare3;

    private String welfare4;

    private String welfare5;

    private String welfare6;

    private String welfare7;

    private String welfare8;

    private String welfare9;

    private String welfare10;


}