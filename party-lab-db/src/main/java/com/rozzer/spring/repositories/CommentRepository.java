package com.rozzer.spring.repositories;

import com.rozzer.model.Case;
import com.rozzer.model.Comment;
import com.rozzer.model.UserProject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    List<Comment> findAllByName(String name);

}
