package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Banner;
import com.bestleisure.backend.repository.IBannerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BannerService implements IBannerService{
    final IBannerRepository iBannerRepository;

    public BannerService(IBannerRepository iBannerRepository) {
        this.iBannerRepository = iBannerRepository;
    }

    @Override
    public boolean createBanner(Banner Banner) {
        if(Banner != null){
            iBannerRepository.save(Banner);
            return true;
        }
        else return false;
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
    public boolean deleteBanner(Long id) {
        if(id<=0){
            return false;
        }
        else {iBannerRepository.deleteById(id); return true;}
    }

    @Override
    public boolean deleteBanner(String title) {
        if (title != null) {
            iBannerRepository.deleteBannerByTitle(title);
            return true;
        } else
            return false;
    }
}
