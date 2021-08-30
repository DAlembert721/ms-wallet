package com.everis.mswallet.query.projections.repositories;

import com.everis.mswallet.query.projections.views.Wallet;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface WalletRepository extends BaseRepository<Wallet, String>{
    Mono<Wallet> findByWalletNumber(String walletNumber);
    Mono<Wallet> findByCustomerDocumentNumber(String documentNumber);
    Mono<Wallet> findByDebitCardCardNumber(String cardNumber);
}
