package net.extropy.openweathermcp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherResponse(
    Coord coord,
    Weather[] weather,
    Main main,
    String name // City name
) {
    public record Coord(double lon, double lat) {}
    public record Weather(String main, String description, String icon) {}
    public record Main(double temp, double feels_like, double temp_min, double temp_max,
                       int pressure, int humidity) {}

    public String toReadableString() {
        if (weather != null && weather.length > 0) {
            return String.format("The weather in %s is %s with a temperature of %.1f°C (feels like %.1f°C). Description: %s. Humidity: %d%%.",
                    name, weather[0].main(), main.temp(), main.feels_like(), weather[0].description(), main.humidity());
        }
        return "Could not retrieve detailed weather information.";
    }
}
