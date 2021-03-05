package com.bestleisure.backend.controller;

import com.bestleisure.backend.service.ImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("images")
public class ImageController {
    final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("upload")
    public void uploadFile(MultipartFile file) {
        imageService.save(file);
    }

    //    @CrossOrigin(origins = {"crossServer"})
//    @GetMapping("getAll")
//    public void getAllFiles(){
//
//    }
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("image/{filename}")
    public void getFile(@PathVariable String filename) {
        imageService.load(filename);
    }

}
