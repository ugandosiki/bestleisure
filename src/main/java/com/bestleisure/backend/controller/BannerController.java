package com.bestleisure.backend.controller;

import com.bestleisure.backend.message.ResponseMessage;
import com.bestleisure.backend.model.Banner;
import com.bestleisure.backend.model.Image;
import com.bestleisure.backend.service.BannerService;
import com.bestleisure.backend.service.ImageService;
import com.bestleisure.backend.util.FileUploadUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("banners")
public class BannerController {
    final BannerService bannerService;
    final ImageService imageService;

    public BannerController(BannerService bannerService, ImageService imageService) {
        this.bannerService = bannerService;
        this.imageService = imageService;
    }


    @PostMapping("add")
    public ResponseEntity<ResponseMessage> addBanner(Banner banner, Image image, @RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File is empty"));
        } else {
            bannerService.createBanner(banner);
            FileUploadUtil.upload(file, banner);
            imageService.saveImage(image);
            Image currentImg = imageService.getOneImage(image.getId());
            currentImg.setBanner_id(banner);
            currentImg.setPath("Banner_" + banner.getId() + "_" + banner.getTitle() + ".jpg");
            imageService.saveImage(currentImg);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("File " + file.getOriginalFilename() + " was successfully uploaded!"));

        }
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("get")
    public List<Banner> getAllSubCategories() {
        return bannerService.getAllBanner();
    }
}
