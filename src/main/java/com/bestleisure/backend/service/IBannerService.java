package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Banner;
import com.bestleisure.backend.model.Category;

import java.util.List;

public interface IBannerService {
    boolean createBanner(Banner Banner);
    Banner getOneBanner(Long id);
    Banner getBannerByTitle(String title);
    List<Banner> getAllBanner();
    boolean deleteBanner(Long id);
    boolean deleteBanner(String title);
}
