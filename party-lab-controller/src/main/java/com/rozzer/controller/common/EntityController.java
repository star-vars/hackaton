package com.rozzer.controller.common;

import java.util.List;

public interface EntityController<T> {

    List<T> getAll();
    T create();
    T read(String id);
    T update(T object);
    void delete(T object);

}
