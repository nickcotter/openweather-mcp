package net.extropy.openweathermcp;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class PromptWeatherService {

    private final ChatClient chatClient;

    public PromptWeatherService(ChatClient.Builder builder) {
        chatClient = builder.build();
    }

    public String extractCity(String prompt) {
        String fullPrompt = "Extract the city name from the following sentence: \"" + prompt + "\". Return only the city name.";
        return chatClient.prompt(fullPrompt).call().content();
    }
}

