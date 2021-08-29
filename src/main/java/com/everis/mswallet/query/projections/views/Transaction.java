package com.everis.mswallet.query.projections.views;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Document("Transaction")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    private String id;
    @NotNull
    private Double amount;
    private String transactionNumber;
    private Wallet wallet;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private String concept;
    private TypeTransaction typeTransaction;

    static public String generateTransactionNumber() {
        final String PREFIX = "WTT-";
        Random random = new Random();
        return PREFIX + random.nextInt(999999999);
    }

}