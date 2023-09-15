package com.weather.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RedisConfigTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 테스트 종료 후에 Redis 데이터 삭제
    @AfterEach
    public void cleanup() {
        redisTemplate.getConnectionFactory().getConnection().serverCommands().flushDb();
    }

    @Test
    @DisplayName("redis 연결 테스트")
    public void testRedisConnection() {
        // Redis 연결을 확인하기 위한 Ping-Pong 테스트
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();

        try {
            // Redis 서버에 Ping 요청을 보내어 Pong을 기대합니다.
            String pingResult = connectionFactory.getConnection().ping();

            // Pong이 예상 값인 "PONG"과 일치하는지 확인
            assertEquals("PONG", pingResult);
        } catch (Exception e) {
            // 예외가 발생하면 Redis 서버와의 연결이 실패한 것으로 간주합니다.
            fail("Redis 서버에 연결할 수 없습니다: " + e.getMessage());
        }
    }
}