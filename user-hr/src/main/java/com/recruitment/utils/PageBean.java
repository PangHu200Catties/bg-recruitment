package com.recruitment.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class PageBean<T> implements Serializable {
//  hr id
    private int hid;
    private List<T> list;
    private long total;
    private int page;
    private  int size;
}