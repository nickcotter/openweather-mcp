package net.extropy.openweathermcp;

import java.util.Map;

public class WeatherResponse {
    private Map<String, Object> main;
    private Map<String, Object>[] weather;
    private String name;

    public Map<String, Object> getMain() {
        return main;
    }

    public void setMain(Map<String, Object> main) {
        this.main = main;
    }

    public Map<String, Object>[] getWeather() {
        return weather;
    }

    public void setWeather(Map<String, Object>[] weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
