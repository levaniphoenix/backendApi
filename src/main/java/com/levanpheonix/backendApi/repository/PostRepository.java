package com.levanpheonix.backendApi.repository;

import com.levanpheonix.backendApi.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
