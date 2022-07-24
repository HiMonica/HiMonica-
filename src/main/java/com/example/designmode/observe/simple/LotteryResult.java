package com.example.designmode.observe.simple;

import lombok.Data;

/**
 * 摇号的结果
 */
@Data
public class LotteryResult {

    private String code;
    private String msg;

    private Object data;
}
