package com.rozzer.manager;

import com.rozzer.model.Comment;

import java.util.List;

public interface CommentManager extends Manager<Comment> {

    List<Comment> getAllByProjectId(Long projectId);

}
