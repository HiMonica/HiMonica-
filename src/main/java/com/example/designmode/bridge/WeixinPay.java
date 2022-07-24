package com.example.designmode.bridge;

import java.math.BigDecimal;

public class WeixinPay extends AbstractPay{

    public WeixinPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public void transfer(String uId, String tradeId, BigDecimal amount) {
        payMode.security(uId);
    }
}
