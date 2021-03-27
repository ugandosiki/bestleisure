package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Image;

public interface IImageService {
    void saveImage(Image image);
    Image getOneImage(Long id);
    void deleteImageByPostTitle(String postTitle);
}
