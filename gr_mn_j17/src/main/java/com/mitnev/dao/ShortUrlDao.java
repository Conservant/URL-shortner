package com.mitnev.dao;

import com.mitnev.model.ShortUrl;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface ShortUrlDao extends PageableRepository<ShortUrl, Long> {
    ShortUrl getByShortId(String shortId);
}
