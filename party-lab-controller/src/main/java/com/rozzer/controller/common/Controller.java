package com.rozzer.controller.common;

import java.util.List;
import java.util.Optional;

public interface Controller<T> {

    List<T> getAll();
    T create();
    Optional<T> read(String id);
    void update(T object);
    void delete(T object);

}
