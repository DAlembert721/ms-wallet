package com.everis.mswallet.query.projections.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private String id;

    private Customer customer;

    private String accountNumber;

    private String accountType;

    private Double balance;
}
