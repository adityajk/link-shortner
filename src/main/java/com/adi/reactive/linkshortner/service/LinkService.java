package com.adi.reactive.linkshortner.service;

import com.adi.reactive.linkshortner.entity.Link;
import com.adi.reactive.linkshortner.repository.LinkRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LinkService {

    private final String baseUrl;
    private final LinkRepository linkRepository;

    public LinkService(@Value("${app.baseUrl}") String baseUrl, LinkRepository linkRepository) {
        this.baseUrl = baseUrl;
        this.linkRepository = linkRepository;
    }

    public Mono<String> shortenLink(String link) {
        String randomkey = RandomStringUtils.randomAlphabetic(6);
        //save to database
        return linkRepository.save(new Link(link, randomkey))
                      .map(result -> baseUrl + result.getKey());
    }

    public Mono<Link> getOriginalLink(String key) {
        return linkRepository.findByKey(key);
    }
}
