package com.everis.mswallet.topics.consumer;

import com.everis.mswallet.command.domain.service.WalletCommandService;
import com.everis.mswallet.query.projections.views.Customer;
import com.everis.mswallet.query.projections.views.DebitCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;


@Component
public class WalletConsumer {

    @Autowired
    private WalletCommandService walletCommandService;

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "created-account-topic", groupId = "wallet-group")
    public Disposable retrieveCreatedAccount(String data) throws JsonProcessingException {

        Customer customer = objectMapper.readValue(data, Customer.class);

        return Mono.just(customer)
                .log()
                .flatMap(walletCommandService::updateCustomer)
                .subscribe();

    }

    @KafkaListener(topics = "debit-card-topic", groupId = "wallet-group")
    public Disposable retrieveExistsDebitCard(String data) throws JsonProcessingException {

        DebitCard debitCard = objectMapper.readValue(data, DebitCard.class);

        return Mono.just(debitCard)
                .log()
                .flatMap(walletCommandService::updateDebitCard)
                .subscribe();

    }

}
