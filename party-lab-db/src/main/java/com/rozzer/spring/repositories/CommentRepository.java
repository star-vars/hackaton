package com.rozzer.spring.repositories;

import com.rozzer.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
