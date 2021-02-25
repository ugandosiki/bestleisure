package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.Banner;
import com.bestleisure.backend.service.BannerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("banners")
public class BannerController {
    final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @PostMapping("add")
    public boolean addBanner(Banner banner) {
        if (banner != null) {
            bannerService.createBanner(banner);
            return true;
        } else return false;
    }
}
