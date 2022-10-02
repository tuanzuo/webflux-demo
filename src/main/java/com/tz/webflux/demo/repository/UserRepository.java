package com.tz.webflux.demo.repository;

import com.tz.webflux.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepository {

    private static final String USER_MAP_KEY = "user:map:key";

    @Autowired
    private ReactiveRedisTemplate reactiveRedisTemplate;

    public Mono<User> save(User user) {
        return reactiveRedisTemplate.opsForHash().put(USER_MAP_KEY, user.getUsername(), user);
    }

    public Mono<User> findByUsername(String username) {
        return reactiveRedisTemplate.opsForHash().get(USER_MAP_KEY, username);
    }

    public Mono<Long> deleteByUsername(String username) {
        return reactiveRedisTemplate.opsForHash().remove(USER_MAP_KEY, username);
    }

    public Flux<User> findAll() {
        return reactiveRedisTemplate.opsForHash().values(USER_MAP_KEY);
    }
}
