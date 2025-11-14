package com.chatbot.application_chatbot.controller;

import com.chatbot.application_chatbot.dto.ChatRequest;
import com.chatbot.application_chatbot.dto.ChatResponse;
import com.chatbot.application_chatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:4200") // or you can add * to allow all origins
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String reply = chatService.generateReply(request.getMessage());
        return new ChatResponse(reply);
    }
}
