package com.example.designmode.strategy.并发责任链;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * flow定义
 *
 * @author julu
 * @date 2022/9/21 22:22
 */
public class FlowDefinition {

    /**
     * 分层节点
     */
    private List<List<FlowNode>> flowNodeList = new ArrayList<>();

    /**
     * flow的名称
     */
    private String name;

    /**
     * 获取线程池
     */
    public ExecutorService getExecutor(){
        return ThreadPoolExecutorFactory.threadPoolExecutor;
    }

    /**
     * 放入分层节点
     */
    public void setFlowNodeList(List<List<FlowNode>> flowNodeList) {
        this.flowNodeList = flowNodeList;
    }

    public List<List<FlowNode>> getFlowNodeList() {
        return flowNodeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
