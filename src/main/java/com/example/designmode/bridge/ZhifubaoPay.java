package com.example.designmode.bridge;

import java.math.BigDecimal;

public class ZhifubaoPay extends AbstractPay{

    public ZhifubaoPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public void transfer(String uId, String tradeId, BigDecimal amount) {
        payMode.security(uId);
    }
}
