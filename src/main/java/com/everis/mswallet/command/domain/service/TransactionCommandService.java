package com.everis.mswallet.command.domain.service;

import com.everis.mswallet.command.dto.CreateTransaction;
import com.everis.mswallet.query.dto.TransactionDto;
import com.everis.mswallet.query.projections.views.DebitCard;
import com.everis.mswallet.query.projections.views.Transaction;
import reactor.core.publisher.Mono;

public interface TransactionCommandService {
    Mono<TransactionDto> createTransaction(String walletNumber, CreateTransaction createTransaction);
    Mono<TransactionDto> updateConcept(String concept);
}
