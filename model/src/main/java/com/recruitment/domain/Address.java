package com.recruitment.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    private Integer companyId;

    private String province;

    private String city;

    private String district;

    private String street;

    private String door;

    private Double longitude;

    private Double latitude;

    private String info1;

    private String info2;


}