package com.example.designmode.payDemo;

public class Repository {

    public WalletDO getWalletDO(){
        WalletDO walletDO = new WalletDO();
        walletDO.setBalance(200.0);
        walletDO.setId("123456");
        return walletDO;
    }
}
