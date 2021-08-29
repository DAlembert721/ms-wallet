package com.everis.mswallet.query.service;

import com.everis.mswallet.query.dto.WalletDto;
import com.everis.mswallet.query.projections.repositories.WalletRepository;
import com.everis.mswallet.query.projections.service.WalletQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WalletQueryServiceImpl implements WalletQueryService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Flux<WalletDto> findAll() {
        return walletRepository.findAll()
                .map(WalletDto::entityToDto);
    }

    @Override
    public Mono<WalletDto> findById(String id) {
        return walletRepository.findById(id)
                .map(WalletDto::entityToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<WalletDto> findByWalletNumber(String walletNumber) {
        return walletRepository.findByWalletNumber(walletNumber)
                .map(WalletDto::entityToDto)
                .switchIfEmpty(Mono.empty());
    }
}
