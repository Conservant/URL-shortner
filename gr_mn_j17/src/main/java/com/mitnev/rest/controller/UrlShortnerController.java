package com.mitnev.rest.controller;

import com.mitnev.service.UrlShortnerService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;

@Controller("/")
public class UrlShortnerController {

    @Inject
    private UrlShortnerService urlShortnerService;

    @Post(consumes = MediaType.APPLICATION_JSON)
    public String greet(@Body String longUrl) {
        return urlShortnerService.shortUrl(longUrl);
    }

    @Get("/{shortId}")
    public String shortenUrl_Read(@PathVariable String shortId) {
        return urlShortnerService.getLongUrl(shortId);
    }

}
