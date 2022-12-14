package com.levanpheonix.backendApi.repository;

import com.levanpheonix.backendApi.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment,Long> {
}
