package com.bestleisure.backend.controller;

import com.bestleisure.backend.message.ResponseMessage;
import com.bestleisure.backend.model.Image;
import com.bestleisure.backend.model.Post;
import com.bestleisure.backend.model.User;
import com.bestleisure.backend.service.ImageService;
import com.bestleisure.backend.service.PostService;
import com.bestleisure.backend.service.UserService;
import com.bestleisure.backend.util.FileUploadUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("posts")
public class PostController {
    final PostService postService;
    final ImageService imageService;
    final UserService userService;

    public PostController(PostService postService, ImageService imageService, UserService userService) {
        this.postService = postService;
        this.imageService = imageService;
        this.userService = userService;
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
            String ext = FilenameUtils.getExtension(file.getOriginalFilename());
            currentImg.setPath("Post_" + post.getId() + post.getTitle().replaceAll("\\W|\\d|\\s", "") + "." + ext);
            imageService.saveImage(currentImg);

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("File " + file.getOriginalFilename() + " was successfully uploaded!"));
        }
    }

    @GetMapping("get")
    public List<Post> getAllPosts() {
        return postService.getAllPost();
    }


    @GetMapping("get/{title}")
    public Post getPost(@PathVariable String title) {
        return postService.getPostByTitle(title);
    }

    @Transactional
    @PostMapping("delete")
    public ResponseEntity<ResponseMessage> deletePost(String title) throws IOException {
        Post curPost = postService.getPostByTitle(title);
        List<Image> postImages = curPost.getImages();
        String curImage = "";
        for (Image img : postImages) {
            if (img.getPath().contains(curPost.getId().toString())) {
                curImage = img.getPath();
            }
        }

        Long postId = postService.getPostByTitle(title).getId();
        FileUploadUtil.deleteFileFromDir(curImage);
        imageService.deleteImageByPostTitle(title);
        postService.deletePost(title);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Post " + " was successfully deleted!"));
    }

    @PostMapping("addLike")
    public ResponseEntity<ResponseMessage> addLike(Long userID, Long postID) throws IOException {
        User curUser = userService.getOneUser(userID);
        Post curPost = postService.getOnePost(postID);
        curUser.getLikedPosts().add(curPost);
        userService.createUser(curUser);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Like " + " was successfully added!"));
    }

    @Transactional
    @PutMapping("updatedescr/{id}")
    public ResponseEntity<ResponseMessage> updateDescription(String descr, @PathVariable Long id){
        Post curPost = postService.getOnePost(id);
        curPost.setDescription(descr);
        postService.createPost(curPost);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Post " + " was successfully updated!"));
    }
    
    @Transactional
    @PutMapping("updatetitle/{id}")
    public ResponseEntity<ResponseMessage> updateTitle(String title, @PathVariable Long id){
        Post curPost = postService.getOnePost(id);
        curPost.setTitle(title);
        postService.createPost(curPost);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Post " + " was successfully updated!"));
    }
}
