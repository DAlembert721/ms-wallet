package com.everis.mswallet.command.domain.service;

import com.everis.mswallet.command.dto.CreateWallet;
import com.everis.mswallet.command.dto.UpdateWallet;
import com.everis.mswallet.command.dto.WalletCreated;
import com.everis.mswallet.query.dto.TransactionDto;
import com.everis.mswallet.query.dto.WalletDto;
import com.everis.mswallet.query.projections.views.Customer;
import com.everis.mswallet.query.projections.views.DebitCard;
import reactor.core.publisher.Mono;

public interface WalletCommandService {
    Mono<WalletCreated> createWallet(CreateWallet createWallet);
    Mono<WalletDto> updateWallet(UpdateWallet updateWallet);
    Mono<WalletDto> updateDebitCard(DebitCard debitCard);
    Mono<WalletDto> updateCustomer(Customer customer);
}
