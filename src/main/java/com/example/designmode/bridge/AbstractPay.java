package com.example.designmode.bridge;

import java.math.BigDecimal;

public abstract class AbstractPay implements Pay{

    protected IPayMode payMode;

    public AbstractPay(IPayMode payMode) {
        this.payMode = payMode;
    }
}
