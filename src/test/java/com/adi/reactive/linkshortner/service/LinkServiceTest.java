package com.adi.reactive.linkshortner.service;

import com.adi.reactive.linkshortner.entity.Link;
import com.adi.reactive.linkshortner.repository.LinkRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LinkServiceTest {

    private LinkRepository linkRepository = mock(LinkRepository.class);
    private LinkService linkService;

    @Before
    public void setUp() {
        linkService = new LinkService("http://some-domain.com/", linkRepository);
        when(linkRepository.save(any()))
                .thenAnswer((Answer<Mono<Link>>) invocationOnMock -> Mono.just((Link) invocationOnMock.getArguments()[0]));
    }

    @Test
    public void shortenLink() {
        StepVerifier.create(linkService.shortenLink("http://spring.io"))
                    .expectNextMatches(result -> null != result && result.length() > 0
                    && result.startsWith("http://some-domain.com/"))
                    .expectComplete()
                    .verify();
    }

}