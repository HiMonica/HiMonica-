package com.example.designmode.observe.simple;

import com.example.designmode.observe.simple.LotteryResult;
import com.example.designmode.observe.simple.LotteryService;
import com.example.designmode.observe.simple.LotteryServiceImpl;

public class Test {

    public static void main(String[] args) {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.doDrew("18281235812");
        System.out.println(result);
    }
}
