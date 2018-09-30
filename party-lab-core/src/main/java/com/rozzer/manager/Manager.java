package com.rozzer.manager;

import com.rozzer.common.Saved;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface Manager<T extends Saved> {
    List<T> getAll();
    List<T> getAllByPage(Pageable page);
    long countAll();
    T save(T saved);
    void delete(T saved);
    Optional<T> getById(Long id);
    List<T> getByName(String name);
    T create();
}
