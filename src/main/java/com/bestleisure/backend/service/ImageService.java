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
        try {
            iImageRepository.save(image);
        } catch (Exception exception) {
            throw new RuntimeException("Could not store the file. Error: " + exception.getMessage());
        }
    }

    @Override
    public Image getOneImage(Long id) {
        return iImageRepository.getOne(id);
    }

    @Override
    public void deleteImageByPostTitle(String postTitle) {
        iImageRepository.deleteImageByPostTitle(postTitle);
    }
}
