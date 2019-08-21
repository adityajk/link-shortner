package com.adi.reactive.linkshortner.repository;

import com.adi.reactive.linkshortner.entity.Link;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class RedisLinkRepository implements LinkRepository {

    private final ReactiveRedisOperations<String, String> operations;

    @Override
    public Mono<Link> save(Link link) {
        return operations.opsForValue()
                .set(link.getKey(), link.getOriginalLink())
                .map(__ -> link);
    }

    @Override
    public Mono<Link> findByKey(String key) {
        return operations.opsForValue()
                .get(key)
                .map(result -> new Link(result, key));
    }
}
