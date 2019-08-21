package com.adi.reactive.linkshortner.controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class HelloFlux {



  Flux<String> emptyFlux() {
    return Flux.empty();
  }

  Flux<String> fooBarFluxFromValues() {
    return Flux.just("foo", "bar");
  }

  Mono<String> fooMono() {
    return Mono.just("foo");
  }
 }
