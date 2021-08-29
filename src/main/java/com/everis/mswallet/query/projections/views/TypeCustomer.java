package com.everis.mswallet.query.projections.views;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TypeCustomer {
    String id;

    EnumTypeCustomer value;

    SubType subType;

    public enum EnumTypeCustomer {
        EMPRESARIAL, PERSONAL
    }
}
