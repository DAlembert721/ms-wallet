package com.everis.mswallet.command.dto;

import com.everis.mswallet.query.projections.views.Customer;
import com.everis.mswallet.query.projections.views.Wallet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WalletCreated {
    private String id;
    private String walletNumber;

    static public WalletCreated entityToDto(Wallet wallet) {
        WalletCreated walletCreated = new WalletCreated();
        walletCreated.setWalletNumber(wallet.getWalletNumber());
        walletCreated.setId(wallet.getId());
        return walletCreated;
    }
}
