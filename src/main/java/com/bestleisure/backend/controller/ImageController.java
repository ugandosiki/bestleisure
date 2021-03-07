package com.bestleisure.backend.controller;

import com.bestleisure.backend.message.ResponseMessage;
import com.bestleisure.backend.model.Banner;
import com.bestleisure.backend.util.FileUploadUtil;
import com.bestleisure.backend.model.Image;
import com.bestleisure.backend.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class ImageController<T> {

}
