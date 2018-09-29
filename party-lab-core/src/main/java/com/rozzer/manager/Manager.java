package com.rozzer.manager;

import com.rozzer.common.Saved;

import java.util.List;
import java.util.Optional;

public interface Manager<T extends Saved> {
    List<T> getAll();
    void save(T saved);
    void delete(T saved);
    Optional<T> getById(Long id);
    T create();
}
