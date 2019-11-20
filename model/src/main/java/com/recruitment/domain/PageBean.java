package com.recruitment.domain;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    private List<T> list;
    private long total;
    private int page;
    private  int size;
    private String address;
}
