package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Banner;
import com.bestleisure.backend.repository.IBannerRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService implements IBannerService {
    final IBannerRepository iBannerRepository;

    public BannerService(IBannerRepository iBannerRepository) {
        this.iBannerRepository = iBannerRepository;
    }

    @Override
    public void createBanner(Banner banner) {
        try {
            iBannerRepository.save(banner);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException("Not a banner" + exception.getMessage());
        }
    }

    @Override
    public Banner getOneBanner(Long id) {
        return iBannerRepository.getOne(id);
    }

    @Override
    public Banner getBannerByTitle(String name) {
        return iBannerRepository.findBannerByTitle(name);
    }

    @Override
    public List<Banner> getAllBanner() {
        return iBannerRepository.findAll();
    }

    @Override
    public void deleteBanner(Long id) {
        try {
            iBannerRepository.deleteById(id);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("Not a valid id" + exception.getMessage());
        }
    }

    @Override
    public void deleteBanner(String title) {
        try {
            iBannerRepository.deleteBannerByTitle(title);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("Not a valid title" + exception.getMessage());
        }
    }
}
