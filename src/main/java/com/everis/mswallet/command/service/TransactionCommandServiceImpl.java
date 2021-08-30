package com.everis.mswallet.command.service;

import com.everis.mswallet.command.domain.service.TransactionCommandService;
import com.everis.mswallet.command.dto.CreateTransaction;
import com.everis.mswallet.query.dto.TransactionDto;
import com.everis.mswallet.query.projections.views.DebitCard;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TransactionCommandServiceImpl implements TransactionCommandService {
    @Override
    public Mono<TransactionDto> createTransaction(String walletNumber, CreateTransaction createTransaction) {
        return null;
    }

    @Override
    public Mono<TransactionDto> updateConcept(String concept) {
        return null;
    }
}
