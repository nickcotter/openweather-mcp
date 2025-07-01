package net.extropy.openweathermcp;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class WeatherToolService {

    private final OpenWeatherClient openWeatherClient;

    public WeatherToolService(OpenWeatherClient openWeatherClient) {
        this.openWeatherClient = openWeatherClient;
    }

    /**
     * Gets the current weather for a specified city.
     * @param cityName The name of the city to get the weather for.
     * @return A readable string containing weather information.
     */
    @Tool(description = "Get the current weather for a specified city. Input is the city name.")
    public String getWeather(String cityName) {
        WeatherResponse weatherResponse = openWeatherClient.getWeatherForCity(cityName);
        if (weatherResponse != null) {
            return weatherResponse.toReadableString();
        } else {
            return "Unable to retrieve weather for " + cityName + ". Please check the city name.";
        }
    }
}