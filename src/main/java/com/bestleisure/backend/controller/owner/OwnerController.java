package com.bestleisure.backend.controller.owner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("owner")
public class OwnerController {
    @GetMapping("get")
    public String getOwner() {
        return "Hello owner";
    }
}
