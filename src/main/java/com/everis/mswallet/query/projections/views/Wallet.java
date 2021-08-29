package com.everis.mswallet.query.projections.views;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("Wallet")
@Getter
@Setter
@NoArgsConstructor
public class Wallet {
    private String id;

    private Customer customer;

    private String walletNumber;

    private String password;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate = LocalDate.now();

    private DebitCard debitCard;

    static public String generateWalletNumber() {
        final String PREFIX = "WT-";
        Random random = new Random();
        return PREFIX + random.nextInt(999999999);
    }

}
