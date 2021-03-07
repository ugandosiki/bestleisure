package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Post;

import java.util.List;

public interface IPostService {
    void createPost(Post post);
    Post getOnePost(Long id);
    Post getPostByTitle(String title);
    List<Post> getAllPost();
    void deletePost(Long id);
    void deletePost(String name);
}
