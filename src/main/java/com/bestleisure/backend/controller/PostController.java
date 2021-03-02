package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.Post;
import com.bestleisure.backend.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {
    final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @CrossOrigin(origins = {"crossServer"})
    @PostMapping("add")
    public boolean addPost(Post post){
        if (post != null) {
            postService.createPost(post);
            return true;
        } else return false;
    }

    @CrossOrigin(origins = {"crossServer"})
    @GetMapping("get")
    public List<Post> getAllPosts() {
        return postService.getAllPost();
    }
}
