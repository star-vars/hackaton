package com.rozzer.spring.repositories;

import com.rozzer.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    List<Comment> findAllByName(String name);
    List<Comment> findAllByProject_Id(Long projectId);

}
