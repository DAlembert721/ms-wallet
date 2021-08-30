package com.everis.mswallet.command.domain.model;

import com.everis.mswallet.command.dto.CreateWallet;
import com.everis.mswallet.query.projections.views.Customer;
import com.everis.mswallet.query.projections.views.DocumentType;
import com.everis.mswallet.query.projections.views.TypeCustomer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCustomer {
    private String name;
    private String lastName;
    private TypeCustomer typeCustomer;
    private DocumentType documentType;
    private String documentNumber;
    private String gender;

    static public CreateCustomer buildCreateCustomer(CreateWallet createWallet) {
        CreateCustomer createConsumer = new CreateCustomer();
        createConsumer.setDocumentNumber(createWallet.getDocumentNumber());
        createConsumer.setGender(createWallet.getGender());
        createConsumer.setDocumentType(createWallet.getDocumentType());
        createConsumer.setLastName(createWallet.getLastName());
        createConsumer.setName(createWallet.getName());
        createConsumer.setDocumentNumber(createWallet.getDocumentNumber());
        return createConsumer;
    }


}
