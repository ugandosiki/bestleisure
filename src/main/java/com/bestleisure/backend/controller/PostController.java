package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.Image;
import com.bestleisure.backend.model.Post;
import com.bestleisure.backend.service.ImageService;
import com.bestleisure.backend.service.PostService;
import com.bestleisure.backend.util.FileUploadUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("posts")
public class PostController {
    final PostService postService;
    final ImageService imageService;
    final ImageController imageController;

    public PostController(PostService postService, ImageService imageService, ImageController<Post> imageController) {
        this.postService = postService;
        this.imageService = imageService;
        this.imageController = imageController;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("add")
    public void addPost(Post post, @RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File is empty ");
        } else {
            postService.createPost(post);
            FileUploadUtil.upload(file,post);
        }
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("get")
    public List<Post> getAllPosts() {
        return postService.getAllPost();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("get/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getOnePost(id);
    }
}
