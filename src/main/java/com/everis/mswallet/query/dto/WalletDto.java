package com.everis.mswallet.query.dto;

import com.everis.mswallet.query.projections.views.Customer;
import com.everis.mswallet.query.projections.views.Wallet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class WalletDto {
    private String id;

    private Customer customer;

    private String walletNumber;


    public static WalletDto entityToDto(Wallet wallet) {
        WalletDto walletDto = new WalletDto();
        walletDto.setId(wallet.getId());
        walletDto.setWalletNumber(wallet.getWalletNumber());
        walletDto.setCustomer(wallet.getCustomer());
        return walletDto;
    }
}
