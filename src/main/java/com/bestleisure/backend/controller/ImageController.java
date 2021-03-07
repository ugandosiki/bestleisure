package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.Banner;
import com.bestleisure.backend.util.FileUploadUtil;
import com.bestleisure.backend.model.Image;
import com.bestleisure.backend.service.ImageService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("images")
public class ImageController {
    final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("upload")
    public void upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File is empty: ");
        } else {
            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            String uploadDir = "uploads/";
            FileUploadUtil.saveFile(uploadDir, filename, file);
            Image image = new Image(filename);
            imageService.saveImage(image);
        }
    }
}
