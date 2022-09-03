package com.mitnev.service.impl;

import com.mitnev.dao.ShortUrlDao;
import com.mitnev.model.ShortUrl;
import com.mitnev.service.UrlShortnerService;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import nano_id.NanoID;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class UrlShortnerServiceImpl implements UrlShortnerService {

    private Map<String, ShortUrl> shortToLongUrlMap = new HashMap<>();

    @Inject
    private ShortUrlDao shortUrlDao;

    @Value("${micronaut.application.short_id_length}")
    private int shortIdLenght;

    private Map<String, String> map = new HashMap<>();

    @Override
    public String shortUrl(String longUrl) {
        var shortUrl = NanoID.nanoID(shortIdLenght);
        var shortUrlEntity = ShortUrl.builder()
                .shortId(shortUrl)
                .longUrl(longUrl).build();
//        shortUrlDao.save(shortUrlEntity);
        shortToLongUrlMap.put(shortUrl, shortUrlEntity);
        return shortUrl;
    }

    @Override
    public String getLongUrl(String shortUrl) {
//        ShortUrl byShortId = shortUrlDao.getByShortId(shortUrl);
        var shotUrl = shortToLongUrlMap.get(shortUrl);
        return shotUrl.getLongUrl();
    }
}
