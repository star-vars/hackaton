package com.rozzer.manager;

import com.rozzer.common.Saved;

import java.util.List;

public interface Manager<T extends Saved> {
    List<T> getAll();
    void save(T book);
    void delete(T book);
    T getById(Long id);
    T create();
}
