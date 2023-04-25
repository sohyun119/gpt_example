package com.example.WeatherProjectGPT.service;

import com.example.WeatherProjectGPT.repository.OpenAiRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class OpenAiService {
    private final OpenAiRepository openAiRepository;

    @Value("${openAiApi.key}")
    private String gptApiKey;

    public OpenAiService(OpenAiRepository openAiRepository) {
        this.openAiRepository = openAiRepository;
    }

    public String getGptApiString(String prompt){
        String gptApiUrl = "https://api.openai.com/v1/completions";

        try {
            URL url = new URL(gptApiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("Post");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Authorization", "Bearer"+gptApiKey);

            String input = "{\"model\" : \"text-davinci-003\" , \"prompt\":\"" + prompt+"\",\"max_tokens\" : 1000, \"temperature\": 0.5 }";

            try(OutputStream os = connection.getOutputStream()){
                byte[] inputBytes = input.getBytes("utf-8");
                os.write(inputBytes, 0, inputBytes.length);
            }

            int responseCodeCode = connection.getResponseCode();
            BufferedReader br;
            if(responseCodeCode == 200){
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }else{
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            String inputLine;
            StringBuilder response = new StringBuilder();
            while((inputLine = br.readLine()) != null){
                response.append(inputLine);
            }
            br.close();
            return response.toString();
        } catch (Exception e) {
            return "failed to get response";
        }

    }



}
