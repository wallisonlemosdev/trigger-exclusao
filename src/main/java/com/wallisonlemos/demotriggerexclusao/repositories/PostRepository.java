package com.wallisonlemos.demotriggerexclusao.repositories;

import com.wallisonlemos.demotriggerexclusao.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
