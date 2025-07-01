package net.extropy.openweathermcp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient; 
import reactor.core.publisher.Mono;

@Component
public class OpenWeatherClient {

    private final WebClient webClient;

    @Value("${openweather.api.key}")
    private String apiKey;

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5";

    public OpenWeatherClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    public WeatherResponse getWeatherForCity(String cityName) {

        Mono<WeatherResponse> responseMono = webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path("/weather")
                    .queryParam("q", cityName)
                    .queryParam("appid", apiKey)
                    .queryParam("units", "metric")
                    .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class);

        try {
            return responseMono.block();
        } catch (Exception e) {
            System.err.println("Error fetching weather for " + cityName + ": " + e.getMessage());
            return null;
        }
    }
}