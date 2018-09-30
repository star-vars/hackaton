package com.rozzer.service;

import java.util.Collections;
import java.util.List;

public class ListResult<T> {

    private List<T> data;
    private long total;

    public static <T> ListResult<T> of(List<T> data, long total) {
        ListResult<T> listResult = new ListResult<>();
        listResult.data = data;
        listResult.total = total;
        return listResult;
    }

    public static <T> ListResult<T> of(List<T> data) {
        ListResult<T> listResult = new ListResult<>();
        listResult.data = data;
        listResult.total = data.size();
        return listResult;
    }

    public static <T> ListResult<T> of() {
        ListResult<T> listResult = new ListResult<>();
        listResult.data = Collections.emptyList();
        listResult.total = 0;
        return listResult;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
