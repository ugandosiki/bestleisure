package com.bestleisure.backend.util;

import com.bestleisure.backend.message.ResponseMessage;
import com.bestleisure.backend.model.Banner;
import com.bestleisure.backend.model.Image;
import com.bestleisure.backend.model.Post;
import com.bestleisure.backend.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public  class FileUploadUtil {
    static ImageService imageService;

    public FileUploadUtil(ImageService imageService) {
        FileUploadUtil.imageService = imageService;
    }

    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }


    public static ResponseEntity<ResponseMessage> upload(@RequestParam("file") MultipartFile file, Post post) {
        String message = "";
        try {
            String filename = "Post_"+  post.getId()+"_"+post.getTitle()+".jpg";
            String uploadDir = "uploads/";
            FileUploadUtil.saveFile(uploadDir, filename, file);
            Image image = new Image(filename);
            imageService.saveImage(image);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception exception) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    public static ResponseEntity<ResponseMessage> upload(@RequestParam("file") MultipartFile file, Banner banner) {
        String message = "";
        String uploadDir = "uploads/";
        try {
            String filename = "Banner_"+  banner.getId()+"_"+banner.getTitle()+".jpg";
            FileUploadUtil.saveFile(uploadDir, filename, file);
            Image image = new Image(filename);
            imageService.saveImage(image);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception exception) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
}
