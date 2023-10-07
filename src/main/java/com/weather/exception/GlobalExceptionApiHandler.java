package com.weather.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleNotFoundException(HttpClientErrorException.NotFound ex) {
        // HTTP 404 NotFound 예외 처리
        log.error("올바르지 않은 API URL");
        return new ResponseEntity<>("유효하지 않은 API URL 접근: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RedisConnectionFailureException.class)
    public ResponseEntity<String> handleRedisConnectionFailureException(RedisConnectionFailureException ex) {
        // Redis 연결 문제 예외 처리
        log.error("Redis 연결 불가");
        return new ResponseEntity<>("Redis 연결 문제: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<String> handleJsonProcessingException(JsonProcessingException ex) {
        // 예외 처리 로직 작성
        log.error("JSON 처리 중 오류 발생: " + ex.getMessage());
        return new ResponseEntity<>("JSON 처리 중 오류: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
