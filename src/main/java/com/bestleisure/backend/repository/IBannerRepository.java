package com.bestleisure.backend.repository;

import com.bestleisure.backend.model.Banner;
import com.bestleisure.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBannerRepository extends JpaRepository<Banner, Long> {
    Banner findBannerByTitle(String title);
    void deleteBannerByTitle(String title);
}
