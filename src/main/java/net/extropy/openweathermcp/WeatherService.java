package net.extropy.openweathermcp;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final PromptWeatherService promptWeatherService;
    private final OpenWeatherClient openWeatherClient;

    public WeatherService(PromptWeatherService promptWeatherService, OpenWeatherClient openWeatherClient) {
        this.promptWeatherService = promptWeatherService;
        this.openWeatherClient = openWeatherClient;
    }

    public WeatherResponse getWeatherByQuery(String query) {
        String city = promptWeatherService.extractCity(query);
        return openWeatherClient.getWeather(city);
    }
}

