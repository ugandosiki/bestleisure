package com.bestleisure.backend.controller;

import com.bestleisure.backend.message.ResponseMessage;
import com.bestleisure.backend.model.Image;
import com.bestleisure.backend.model.Post;
import com.bestleisure.backend.service.ImageService;
import com.bestleisure.backend.service.PostService;
import com.bestleisure.backend.util.FileUploadUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("posts")
public class PostController {
    final PostService postService;
    final ImageService imageService;

    public PostController(PostService postService, ImageService imageService) {
        this.postService = postService;
        this.imageService = imageService;

    }


    @PostMapping("add")
    public ResponseEntity<ResponseMessage> addPost(Post post, Image image, @RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File is empty"));
        } else {
            postService.createPost(post);

            FileUploadUtil.upload(file, post);

            imageService.saveImage(image);
            Image currentImg = imageService.getOneImage(image.getId());
            currentImg.setPost(post);
            currentImg.setPath("Post_" + post.getId() + "_" + post.getTitle() + ".jpg");
            imageService.saveImage(currentImg);

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("File " + file.getOriginalFilename() + " was successfully uploaded!"));
        }
    }


    @GetMapping("get")
    public List<Post> getAllPosts() {
        return postService.getAllPost();
    }


    @GetMapping("get/{id}")
    public Post getPost(@PathVariable Long id) {

        return postService.getOnePost(id);
    }
}
