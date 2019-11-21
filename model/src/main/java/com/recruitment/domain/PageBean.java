package com.recruitment.domain;

import lombok.Data;

import java.util.List;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/14
 * @Time: 10:23
 * @description:
 */
@Data
public class PageBean<T> {
    private List<T> list;
    private long total;
    private int page;
    private  int size;
    private String address;
}
