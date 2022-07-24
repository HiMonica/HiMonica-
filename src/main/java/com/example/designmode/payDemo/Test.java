package com.example.designmode.payDemo;

import org.apache.commons.collections.MapUtils;

public class Test {

    public static void main(String[] args) {
        PayServiceImpl payService = new PayServiceImpl();
        payService.pay("123213",20.0);
    }
}
