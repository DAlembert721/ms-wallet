package com.everis.mswallet.query.projections.views;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private String id;

    private String name;

    private String lastName;

    private TypeCustomer typeCustomer;

    private DocumentType documentType;

    private String documentNumber;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    private String gender;

}
