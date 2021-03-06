package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Image;

public interface IImageService {
    void saveImage(Image image);

    void deleteImage();

}
