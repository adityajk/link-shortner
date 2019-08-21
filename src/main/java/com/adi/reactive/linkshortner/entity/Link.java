package com.adi.reactive.linkshortner.entity;

import lombok.Value;

@Value
public class Link {
    String originalLink;
    String key;
}
