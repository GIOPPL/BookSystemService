package com.ahut.model;

import java.io.Serializable;

/**
 * Created by GIOPPL
 * on 2020/10/25 17:07
 * TODO:通过isbn查询的bean类
 */
public class SearchByStringBean implements Serializable {
    private String data;
    private int page;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
