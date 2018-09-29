package com.rozzer.controller.common;

import java.util.List;

public interface Controller<T> {

    List<T> getAll();
    T create();
    T read(String id);
    void update(T object);
    void delete(T object);

}
