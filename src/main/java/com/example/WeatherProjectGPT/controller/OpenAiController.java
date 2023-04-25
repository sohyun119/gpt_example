package com.example.WeatherProjectGPT.controller;

import com.example.WeatherProjectGPT.service.OpenAiService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class                                                                                                                                                                                                                                                                                                         OpenAiController {
    private final OpenAiService openAiService;

    public OpenAiController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @GetMapping("/apiTest")
    public void testOpenAiApi(){
        String prompt = "4월 서울에서 해가 뜨는 시간을 알려줘.";

        String result = openAiService.getGptApiString(prompt);

    }
}
