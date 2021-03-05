package com.bestleisure.backend.service;

import org.springframework.web.multipart.MultipartFile;

public interface IImageService {
    void init();

    void save(MultipartFile file);

    void load(String filename);

    void deleteAll();

//     Stream<Path> loadAll();

}
