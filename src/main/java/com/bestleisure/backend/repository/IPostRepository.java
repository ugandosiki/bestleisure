package com.bestleisure.backend.repository;

import com.bestleisure.backend.model.Category;
import com.bestleisure.backend.model.Post;
import com.bestleisure.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Long> {
    Post findPostByTitle(String title);
    boolean deletePostByTitle(String title);
}
