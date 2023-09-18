package com.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    @JsonProperty("name")
    private String cityName;

    @JsonProperty("coord")
    private Coord coord;

    @JsonProperty("weather")
    private Weather[] weather;

    @JsonProperty("main")
    private Main main;

    @JsonProperty("wind")
    private Wind wind;

    @JsonProperty("clouds")
    private Clouds clouds;

    @JsonProperty("sys")
    private Sys sys;

    @Getter
    public static class Coord {
        @JsonProperty("lon")
        private Double lon;

        @JsonProperty("lat")
        private Double lat;
    }

    @Getter
    public static class Weather {
        @JsonProperty("description")
        private String description;
    }

    @Getter
    public static class Main {
        @JsonProperty("temp")
        private Double temp;

        @JsonProperty("feels_like")
        private Double feels_like;

        @JsonProperty("temp_min")
        private Double temp_min;

        @JsonProperty("temp_max")
        private Double temp_max;

        @JsonProperty("pressure")
        private Integer pressure;

        @JsonProperty("humidity")
        private Integer humidity;
    }

    @Getter
    public static class Wind {
        @JsonProperty("speed")
        private Double speed;

        @JsonProperty("deg")
        private Integer deg;
    }

    @Getter
    public static class Clouds {
        @JsonProperty("all")
        private Integer all;
    }

    @Getter
    public static class Sys {
        @JsonProperty("country")
        private String country;

        @JsonProperty("sunrise")
        private Long sunrise;

        @JsonProperty("sunset")
        private Long sunset;
    }
}
