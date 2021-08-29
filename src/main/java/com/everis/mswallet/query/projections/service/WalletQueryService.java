package com.everis.mswallet.query.projections.service;

import com.everis.mswallet.query.dto.WalletDto;
import com.everis.mswallet.query.projections.views.Wallet;
import reactor.core.publisher.Mono;

public interface WalletQueryService extends BaseQueryService<Wallet, WalletDto, String>{
    Mono<WalletDto> findByWalletNumber(String walletNumber);
}
