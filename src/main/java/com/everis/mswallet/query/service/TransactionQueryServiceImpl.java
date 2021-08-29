package com.everis.mswallet.query.service;

import com.everis.mswallet.query.dto.TransactionDto;
import com.everis.mswallet.query.projections.repositories.TransactionRepository;
import com.everis.mswallet.query.projections.service.TransactionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionQueryServiceImpl implements TransactionQueryService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Flux<TransactionDto> findAll() {
        return transactionRepository.findAll()
                .map(TransactionDto::entityToDto)
                .onErrorResume(Mono::error);
    }

    @Override
    public Mono<TransactionDto> findById(String id) {
        return transactionRepository.findById(id)
                .map(TransactionDto::entityToDto)
                .switchIfEmpty(Mono.empty())
                .onErrorResume(Mono::error);
    }

    @Override
    public Flux<TransactionDto> findAllTransactionsByWalletId(String walletId) {
        return transactionRepository.findAllByWalletId(walletId)
                .map(TransactionDto::entityToDto)
                .switchIfEmpty(Mono.empty())
                .onErrorResume(Mono::error);
    }
}
