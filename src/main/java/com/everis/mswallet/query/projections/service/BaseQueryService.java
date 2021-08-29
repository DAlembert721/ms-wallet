package com.everis.mswallet.query.projections.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BaseQueryService<T, R, ID> {
    Flux<R> findAll();
    Mono<R> findById(ID id);
}
