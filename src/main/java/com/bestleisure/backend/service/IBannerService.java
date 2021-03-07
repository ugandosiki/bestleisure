package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Banner;

import java.util.List;

public interface IBannerService {
    void createBanner(Banner Banner);
    Banner getOneBanner(Long id);
    Banner getBannerByTitle(String title);
    List<Banner> getAllBanner();
    void deleteBanner(Long id);
    void deleteBanner(String title);
}
