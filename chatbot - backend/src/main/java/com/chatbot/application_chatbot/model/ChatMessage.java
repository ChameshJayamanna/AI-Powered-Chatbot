package com.chatbot.application_chatbot.model;

public class ChatMessage {

    private String userMessage;
    private String botReply;

    public ChatMessage(String userMessage, String botReply) {
        this.userMessage = userMessage;
        this.botReply = botReply;
    }

    public String getUserMessage() { return userMessage; }
    public String getBotReply() { return botReply; }

}
