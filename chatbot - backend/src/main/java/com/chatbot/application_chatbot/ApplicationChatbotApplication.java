package com.chatbot.application_chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ApplicationChatbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationChatbotApplication.class, args);
	}

}
