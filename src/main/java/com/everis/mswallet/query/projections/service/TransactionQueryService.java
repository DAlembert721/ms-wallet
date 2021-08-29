package com.everis.mswallet.query.projections.service;

import com.everis.mswallet.query.dto.TransactionDto;
import com.everis.mswallet.query.projections.views.Transaction;
import reactor.core.publisher.Flux;

public interface TransactionQueryService extends BaseQueryService<Transaction, TransactionDto, String>{
    Flux<TransactionDto> findAllTransactionsByWalletId(String walletId);
}
