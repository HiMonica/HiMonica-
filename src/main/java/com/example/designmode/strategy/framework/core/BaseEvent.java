package com.example.designmode.strategy.framework.core;

import lombok.Data;

/**
 * @author julu
 * @date 2022/9/12 23:01
 */
@Data
public abstract class BaseEvent implements Event{

    /**
     * 业务唯一id
     */
    private String bizId;
}
