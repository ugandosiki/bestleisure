package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Category;
import com.bestleisure.backend.model.Post;

import java.util.List;

public interface IPostService {
    boolean createPost(Post post);
    Post getOnePost(Long id);
    Post getPostByTitle(String title);
    List<Post> getAllPost();
    boolean deletePost(Long id);
    boolean deletePost(String name);
}
