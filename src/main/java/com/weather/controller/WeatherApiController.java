package com.weather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.dto.WeatherResponse;
import com.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/weather")
public class WeatherApiController {
    private final WeatherService weatherService;

    private final ObjectMapper objectMapper;

    @SneakyThrows
    @GetMapping("/current")
    public ResponseEntity<WeatherResponse> getCurrentWeather(@RequestParam String city) {
        String weatherData = weatherService.getCurrentWeather(city);
        WeatherResponse weatherResponse = objectMapper.readValue(weatherData, WeatherResponse.class);
        return ResponseEntity.ok().body(weatherResponse);
    }
}
