package com.bestleisure.backend.repository;

import com.bestleisure.backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Long> {
    Image findImageByPath(String path);
    void deleteImageByPostTitle(String postTitle);
}
