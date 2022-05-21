package com.example.springboot.Post.domain.repository;


import com.example.springboot.Post.domain.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    Optional<PostEntity> findById(String accountId);
}
