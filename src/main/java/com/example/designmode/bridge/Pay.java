package com.example.designmode.bridge;

import java.math.BigDecimal;

public interface Pay {

    void transfer(String uId, String tradeId, BigDecimal amount);
}
