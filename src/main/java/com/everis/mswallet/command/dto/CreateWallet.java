package com.everis.mswallet.command.dto;

import com.everis.mswallet.command.domain.model.CreateCustomer;
import com.everis.mswallet.query.projections.views.Customer;
import com.everis.mswallet.query.projections.views.DebitCard;
import com.everis.mswallet.query.projections.views.DocumentType;
import com.everis.mswallet.query.projections.views.Wallet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateWallet {
    private String name;
    private String lastName;
    private DocumentType documentType;
    private String documentNumber;
    private String password;
    private String debitCardNumber;
    private String gender;


    static public Wallet buildWallet(CreateWallet createWallet) {
        Wallet wallet = new Wallet();
        wallet.setWalletNumber(Wallet.generateWalletNumber());
        wallet.setPassword(createWallet.getPassword());
        Customer customer = new Customer();
        customer.setName(createWallet.getName());
        customer.setDocumentNumber(createWallet.getDocumentNumber());
        customer.setDocumentType(createWallet.getDocumentType());
        wallet.setCustomer(customer);
        DebitCard debitCard = new DebitCard();
        if (createWallet.getDebitCardNumber() != null) {
            debitCard.setCardNumber(createWallet.getDebitCardNumber());
        }
        wallet.setDebitCard(debitCard);
        return wallet;
    }
}
