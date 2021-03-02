package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.Banner;
import com.bestleisure.backend.service.BannerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("banners")
public class BannerController {
    final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @CrossOrigin(origins = {"crossServer"})
    @PostMapping("add")
    public boolean addBanner(Banner banner) {
        if (banner != null) {
            bannerService.createBanner(banner);
            return true;
        } else return false;
    }

    @CrossOrigin(origins = {"crossServer"})
    @GetMapping("get")
    public List<Banner> getAllSubCategories() {
        return bannerService.getAllBanner();
    }
}
