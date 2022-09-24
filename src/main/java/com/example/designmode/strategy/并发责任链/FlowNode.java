package com.example.designmode.strategy.并发责任链;

/**
 * 节点接口，一个超级类
 *
 * @author julu
 * @date 2022/9/21 22:13
 */
public interface FlowNode {

    /**
     * 节点的执行方法
     */
    FlowResult execute(FlowContext context);
}
