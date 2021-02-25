package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.Post;
import com.bestleisure.backend.service.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
public class PostController {
    final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("add")
    public boolean addPost(Post post){
        if (post != null) {
            postService.createPost(post);
            return true;
        } else return false;
    }
}
