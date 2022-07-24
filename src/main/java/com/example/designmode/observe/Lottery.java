package com.example.designmode.observe;

import com.example.designmode.observe.simple.LotteryResult;

/**
 * 对外暴露的接口
 */
public interface Lottery {

    /**
     * 业务逻辑处理类
      * @param userId
     * @return
     */
    LotteryResult doDraw(String userId);
}
