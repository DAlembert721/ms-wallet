package com.everis.mswallet.command.service;

import com.everis.mswallet.command.domain.model.CreateCustomer;
import com.everis.mswallet.command.domain.service.WalletCommandService;
import com.everis.mswallet.command.dto.CreateWallet;
import com.everis.mswallet.command.dto.UpdateWallet;
import com.everis.mswallet.command.dto.WalletCreated;
import com.everis.mswallet.query.dto.WalletDto;
import com.everis.mswallet.query.projections.repositories.WalletRepository;
import com.everis.mswallet.query.projections.views.Customer;
import com.everis.mswallet.query.projections.views.DebitCard;
import com.everis.mswallet.query.projections.views.Wallet;
import com.everis.mswallet.topics.producer.WalletProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WalletCommandServiceImpl implements WalletCommandService {

    @Autowired
    private WalletProducer walletProducer;

    @Autowired
    private WalletRepository walletRepository;


    @Override
    public Mono<WalletCreated> createWallet(CreateWallet createWallet) {
        CreateCustomer createConsumer = CreateCustomer.buildCreateCustomer(createWallet);
        walletProducer.sendSaveCustomerService(createConsumer);
        if (createWallet.getDebitCardNumber() != null) {
            walletProducer.sendDebitCard(createWallet.getDebitCardNumber());
        }
        Wallet wallet = CreateWallet.buildWallet(createWallet);
        return walletRepository.save(wallet)
                .map(WalletCreated::entityToDto)
                .onErrorResume(Mono::error);

    }

    @Override
    public Mono<WalletDto> updateWallet(UpdateWallet updateWallet) {
        return null;
    }

    @Override
    public Mono<WalletDto> updateDebitCard(DebitCard debitCard) {
        return walletRepository.findByDebitCardCardNumber(debitCard.getCardNumber())
                .flatMap(wallet -> {
                    wallet.setDebitCard(debitCard);
                    return walletRepository.save(wallet);
                }).map(WalletDto::entityToDto)
                .switchIfEmpty(Mono.empty())
                .onErrorResume(Mono::error);
    }

    @Override
    public Mono<WalletDto> updateCustomer(Customer customer) {
        return walletRepository.findByCustomerDocumentNumber(customer.getDocumentNumber())
                .flatMap(wallet -> {
                    wallet.setCustomer(customer);
                    return walletRepository.save(wallet);
                }).map(WalletDto::entityToDto)
                .switchIfEmpty(Mono.empty())
                .onErrorResume(Mono::error);
    }
}
