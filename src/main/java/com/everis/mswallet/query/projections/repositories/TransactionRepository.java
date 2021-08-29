package com.everis.mswallet.query.projections.repositories;

import com.everis.mswallet.query.projections.views.Transaction;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TransactionRepository extends BaseRepository<Transaction, String>{
    Flux<Transaction> findAllByWalletId(String walletId);
}
