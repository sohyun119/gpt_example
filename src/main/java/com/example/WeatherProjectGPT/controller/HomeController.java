package com.example.WeatherProjectGPT.controller;

import com.example.WeatherProjectGPT.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    public final HomeService homeService;

    @GetMapping("/home")
    public String homeTest(){
        return "homeView";
    }


}
