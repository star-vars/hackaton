package com.rozzer.spring.repositories;

import com.rozzer.model.Comment;
import com.rozzer.model.UserProject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findAllByName(String name);

}
