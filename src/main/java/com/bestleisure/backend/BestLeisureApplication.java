package com.bestleisure.backend;

import com.bestleisure.backend.service.ImageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class BestLeisureApplication implements CommandLineRunner {
    @Resource
    ImageService imageService;

    public static void main(String[] args) {
        SpringApplication.run(BestLeisureApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        imageService.deleteAll();
        imageService.init();
    }
}
