package com.weather.controller;

import com.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/current")
    public ResponseEntity<String> getCurrentWeather(@RequestParam String city) {
        String weatherData = weatherService.getCurrentWeather(city);
        return ResponseEntity.ok(weatherData);
    }
}
