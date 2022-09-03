package com.mitnev.service;

public interface UrlShortnerService {
    String shortUrl(String longUrl);
    String getLongUrl(String shortUrl);
}
