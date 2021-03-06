package com.bestleisure.backend;

import com.bestleisure.backend.service.ImageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class BestLeisureApplication  {


    public static void main(String[] args) {
        SpringApplication.run(BestLeisureApplication.class, args);
    }

}
