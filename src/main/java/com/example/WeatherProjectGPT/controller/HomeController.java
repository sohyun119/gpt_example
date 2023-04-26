package com.example.WeatherProjectGPT.controller;

import com.example.WeatherProjectGPT.service.HomeService;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    public final HomeService homeService;

    @Value("${openAiApi.key}")
    public String openAiToken;

    @GetMapping("/home")
    public String homeTest(){
        return "homeView";
    }

    @GetMapping("/chatGPT") // 잘 안되는 이유 알아내기
    public ResponseEntity<?> chatGPT(){

        OpenAiService service = new OpenAiService(openAiToken);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("how are you")
                .model("text-davinci-003")
                .echo(true)
                .build();
        return ResponseEntity.ok(service.createCompletion(completionRequest).getChoices());
    }

    


}
