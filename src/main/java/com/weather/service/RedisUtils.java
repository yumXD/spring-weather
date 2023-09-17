package com.weather.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisUtils {
    private final RedisTemplate<String, Object> redisTemplate;

    public void setData(String key, String value, Long expiredTime) {
        log.info("Redis 데이터 설정 - 키: {}, 값: {}, 만료 시간: {} 분", key, value, expiredTime);
        redisTemplate.opsForValue().set(key, value, expiredTime, TimeUnit.MINUTES);
    }

    public String getData(String key) {
        String value = (String) redisTemplate.opsForValue().get(key);
        if (value != null) {
            log.info("Redis에서 데이터 조회 - 키: {}, 값: {}, 남은 만료 시간: {} 초", key, value, getTTL(key));
        } else {
            log.info("Redis에서 데이터를 찾을 수 없음 - 키: {}", key);
        }
        return value;
    }

    public void deleteData(String key) {
        log.info("Redis 데이터 삭제 - 키: {}", key);
        redisTemplate.delete(key);
    }

    public Long getTTL(String key) {
        // TTL 명령어를 사용하여 키의 만료 시간을 확인
        return redisTemplate.getExpire(key, TimeUnit.SECONDS); // 초 단위로 반환
    }

    public void deleteAllData() {
        log.info("Redis 모든 데이터 삭제");
        redisTemplate.getConnectionFactory().getConnection().serverCommands().flushDb();
    }
}
