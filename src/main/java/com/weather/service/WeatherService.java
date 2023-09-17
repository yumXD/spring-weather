package com.weather.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherService {

    private final RedisUtils redisUtils;

    private final RedisTemplate<String, String> redisTemplate;

    private final RestTemplate restTemplate;

    @Value("${openweathermap.api.url}")
    private String openWeatherMapUrl;

    @Value("${openweathermap.api.key}")
    private String openWeatherMapApiKey;

    public String getCurrentWeather(String city) {
        // Redis에서 캐싱된 날씨 데이터를 가져옵니다.

        String cachedWeatherData = redisUtils.getData(city);

        if (cachedWeatherData != null) {
            // 캐시된 데이터가 있으면 해당 데이터를 반환합니다.
            return cachedWeatherData;
        } else {
            // 캐시된 데이터가 없는 경우, OpenWeatherMap API에서 데이터를 가져옵니다.
            String weatherData = fetchWeatherDataFromApi(city);
            // 가져온 데이터를 특정 만료 시간(예: 1 시간)으로 Redis에 캐싱합니다.
            redisUtils.setData(city, weatherData, 60L);
            return weatherData;
        }
    }

    private String fetchWeatherDataFromApi(String city) {
        // OpenWeatherMap API를 호출하고 도시의 날씨 데이터를 가져옵니다.
        String url = openWeatherMapUrl + "?q=" + city + "&appid=" + openWeatherMapApiKey;
        log.info("OpenWeatherMap API를 호출 url = {}", url);
        // GET 요청을 생성하고 응답을 ResponseEntity로 받습니다.
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        // 응답 데이터를 가져옵니다.
        String weatherData = responseEntity.getBody();

        return weatherData;
    }
}
