package com.rozzer.controller.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EntityController<T> {

    List<T> getAll();
    T create();
    T read(String id);
    T update(T object);
    void delete(T object);

    static Pageable createPage(int page, int size) {
        return PageRequest.of(page - 1, size);
    }

}
