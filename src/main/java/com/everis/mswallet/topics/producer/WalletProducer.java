package com.everis.mswallet.topics.producer;

import com.everis.mswallet.command.domain.model.CreateCustomer;
import com.everis.mswallet.query.projections.views.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class WalletProducer {
    private final static String SERVICE_WALLET_TOPIC = "service-wallet-topic";

    private final static String SERVICE_CREATE_CUSTOMER_TOPIC = "service-create-customer-topic";

    private final static String SERVICE_DEBIT_CARD_TOPIC = "service-debit-card-topic";


    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public WalletProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendSaveCustomerService(CreateCustomer consumer) {
        kafkaTemplate.send(SERVICE_CREATE_CUSTOMER_TOPIC, consumer);
    }

    public void sendTransactionService(Transaction transaction) {
        kafkaTemplate.send(SERVICE_WALLET_TOPIC, transaction);
    }

    public void sendDebitCard(String debitCardNumber) {
        kafkaTemplate.send(SERVICE_DEBIT_CARD_TOPIC, debitCardNumber);
    }
}
