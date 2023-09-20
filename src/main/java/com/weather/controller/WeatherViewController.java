package com.weather.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class WeatherViewController {

    @GetMapping("/")
    public String showCurrentWeather() {
        log.info("현재 날씨 페이지");
        return "weather/currentweather";
    }
}
