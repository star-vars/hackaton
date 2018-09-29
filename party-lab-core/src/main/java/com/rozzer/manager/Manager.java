package com.rozzer.manager;

import com.rozzer.common.Saved;

import java.util.List;
import java.util.Optional;

public interface Manager<T extends Saved> {
    List<T> getAll();
    void save(T book);
    void delete(T book);
    Optional<T> getById(Long id);
    T create();
}
