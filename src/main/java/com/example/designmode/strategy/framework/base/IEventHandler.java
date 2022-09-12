package com.example.designmode.strategy.framework.base;

import com.example.designmode.strategy.framework.core.Event;

/**
 * @author julu
 * @date 2022/9/12 23:05
 */
public interface IEventHandler<E extends Event> {

    /**
     * 事件执行，不抛异常则默认成功
     * @param event
     */
    void handler(E event);

    /**
     * 是否是事件的前置依赖handler
     * @return
     */
    boolean preDependent();

    /**
     * 执行的顺序序号
     * @return
     */
    Integer order();
}
