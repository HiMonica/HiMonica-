package com.example.designmode.bridge;

import java.math.BigDecimal;

public class Test {

    @org.junit.Test
    public void test(){
        WeixinPay weixinPay = new WeixinPay(new PayCypher());
        weixinPay.transfer("1000","1000",new BigDecimal(100));
    }
}
