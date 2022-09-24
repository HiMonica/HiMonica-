package com.example.designmode.strategy.并发责任链;

/**
 * @author julu
 * @date 2022/9/21 22:27
 */
public abstract class AbstractFlowNode<C extends FlowContext> implements FlowNode {

    @Override
    public FlowResult execute(FlowContext context) {
        try {
            return process((C) context);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 子节点实现具体业务的执行逻辑
     *
     * @param context
     * @return
     */
    protected abstract FlowResult process(C context);
}
