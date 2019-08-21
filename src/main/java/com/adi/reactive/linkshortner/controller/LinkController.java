package com.adi.reactive.linkshortner.controller;

import com.adi.reactive.linkshortner.model.CreateLinkRequest;
import com.adi.reactive.linkshortner.model.CreateLinkResponse;
import com.adi.reactive.linkshortner.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping("/link")
    Mono<CreateLinkResponse> create(@RequestBody CreateLinkRequest createLinkRequest) {
        return linkService.shortenLink(createLinkRequest.getLink())
                  .map(CreateLinkResponse::new);
    }

    @GetMapping("/{key}")
    Mono<ResponseEntity<Object>> getLink(@PathVariable String key) {
        return linkService.getOriginalLink(key)
                .map(link -> ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                .header("Location", link.getOriginalLink())
                .build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
