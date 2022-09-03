package com.mitnev.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@MappedEntity
@Builder
public class ShortUrl {
    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;
    private String shortId;
    private String longUrl;
    private Instant createdDate;
    private Instant lastUpdatedDate;
}
