package com.example.designmode.strategy.并发责任链;

import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * @author julu
 * @date 2022/9/24 11:39
 */
public abstract class BaseFlowExecute<C, R> implements FlowExecute, InitializingBean {

    /**
     * flow流程执行信息
     */
    private FlowDefinition flowDefinition;

    /**
     * 注册节点
     * @return
     */
    protected abstract List<List<FlowNode>> register();

    @Override
    public void process(Object context) throws Exception {
        FlowEngine.get().start(flowDefinition, (FlowContext) context);
    }

    /**
     * 注入一些必要的信息
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        flowDefinition = new FlowDefinition();
        List<List<FlowNode>> flowNodeList = register();
        flowDefinition.setFlowNodeList(flowNodeList);
    }
}
