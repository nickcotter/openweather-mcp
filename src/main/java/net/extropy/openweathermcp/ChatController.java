package net.extropy.openweathermcp;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;
    private final WeatherToolService weatherToolService; 

    public ChatController(ChatClient.Builder chatClientBuilder,
                          WeatherToolService weatherToolService) {
        this.chatClient = chatClientBuilder.build();
        this.weatherToolService = weatherToolService;
    }

    @GetMapping("/chat/weather")
    public String chatWithWeather(@RequestParam(value = "message") String message) {
        return chatClient.prompt()
                .user(message)
                .tools(weatherToolService)
                .call()
                .content();
    }
}
