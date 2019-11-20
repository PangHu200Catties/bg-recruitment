package com.recruitment.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Author 王凯
 * Date 2019/11/19
 * Time 20:46
 */
@Entity
@Table(name = "admin")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    private String username;
    private String password;
}
