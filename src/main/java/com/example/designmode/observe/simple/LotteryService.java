package com.example.designmode.observe.simple;

import com.example.designmode.observe.simple.LotteryResult;

/**
 * 摇号的业务逻辑
 */
public interface LotteryService {

    LotteryResult doDrew(String userId);
}
