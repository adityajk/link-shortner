package com.adi.reactive.linkshortner.repository;

import com.adi.reactive.linkshortner.entity.Link;
import reactor.core.publisher.Mono;

public interface LinkRepository {

    Mono<Link> save(Link link);

    Mono<Link> findByKey(String key);
}
