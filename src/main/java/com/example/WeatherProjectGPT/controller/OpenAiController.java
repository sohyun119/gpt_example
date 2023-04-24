package com.example.WeatherProjectGPT.controller;

import com.example.WeatherProjectGPT.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAiController {
    @Value("${openAPI.key}")
    String openAiApiKey;



}
