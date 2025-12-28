package com.chatbot.application_chatbot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatService {

    @Value("${openrouter.api.key}")
    private String apiKey;

    public String generateReply(String userMessage) {

        String url = "https://openrouter.ai/api/v1/chat/completions";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        String requestBody = """
        {
            "model": "openai/gpt-4o-mini",
            "messages": [
                {"role": "user", "content": "%s"}
            ]
        }
        """.formatted(userMessage);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(response.getBody());

            return json.path("choices").get(0)
                    .path("message").path("content").asText();

        } catch (Exception e) {
            e.printStackTrace();
            return "Sorry, I couldn’t process your request right now.";
        }
    }
}
