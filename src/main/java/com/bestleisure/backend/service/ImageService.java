package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Image;
import com.bestleisure.backend.repository.IImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements IImageService {
    private final IImageRepository iImageRepository;

    public ImageService(final IImageRepository iImageRepository) {
        this.iImageRepository = iImageRepository;
    }

    @Override
    public void saveImage(Image image) {
        iImageRepository.save(image);
    }

    @Override
    public void deleteImage() {

    }
}
