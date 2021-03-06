package com.bestleisure.backend.repository;

import com.bestleisure.backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Long> {
    Image findImagebyName(String name);
}
