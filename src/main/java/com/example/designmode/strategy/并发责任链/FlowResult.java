package com.example.designmode.strategy.并发责任链;

/**
 * 节点的返回集
 *
 * @author julu
 * @date 2022/9/21 22:16
 */

public class FlowResult {

    /**
     * 节点是否执行成功，默认成功
     */
    protected Boolean success = Boolean.TRUE;

    public FlowResult() {
    }

    public FlowResult(Boolean success) {
        this.success = success;
    }

    public static FlowResult buildSuccess() {
        return new FlowResult(true);
    }
}
