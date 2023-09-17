package com.weather.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionApiHandler {

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<String> handleUnauthorizedException(HttpClientErrorException.Unauthorized ex) {
        // HTTP 401 Unauthorized 예외 처리
        log.error("올바르지 않은 API KEY");
        return new ResponseEntity<>("인증되지 않은 접근: " + ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(RedisConnectionFailureException.class)
    public ResponseEntity<String> handleRedisConnectionFailureException(RedisConnectionFailureException ex) {
        // Redis 연결 문제 예외 처리
        log.error("Redis 연결 불가");
        return new ResponseEntity<>("Redis 연결 문제: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
