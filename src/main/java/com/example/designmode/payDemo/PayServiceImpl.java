package com.example.designmode.payDemo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PayServiceImpl implements PayService{

    //Spring注入
    Repository repository = new Repository();

    @Override
    public Result pay(String userId,Double money) {
        WalletDO walletDO = repository.getWalletDO();
        VirtualWallet virtualWallet = convert(walletDO);
        virtualWallet.subtract(money);
        log.info("userId:{}进行了支付，支付金额为:{}",userId,money);
        log.info("余额为：{}",virtualWallet.getBalance());
        return null;
    }

    @Override
    public Result transfer(String userId, String toUserId) {
        return null;
    }

    @Override
    public Result withdraw(String userId, String card) {
        return null;
    }

    private VirtualWallet convert(WalletDO walletDO){
        VirtualWallet virtualWallet = new VirtualWallet(walletDO.getId());
        virtualWallet.add(walletDO.getBalance());
        return virtualWallet;
    }
}
