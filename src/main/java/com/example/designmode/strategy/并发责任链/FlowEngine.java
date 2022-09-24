package com.example.designmode.strategy.并发责任链;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 节点分层执行类
 *
 * @author julu
 * @date 2022/9/21 22:33
 */
public class FlowEngine {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlowEngine.class);

    private FlowEngine(){

    }

    /**
     * 流程执行
     */
    public FlowResult start(FlowDefinition flowDefinition, FlowContext flowContext) throws Exception{

        try {
            ExecutorService executorService = flowDefinition.getExecutor();
            List<List<FlowNode>> flowNodeList = flowDefinition.getFlowNodeList();
            //层次执行，每层并发，遇到异常任务或执行失败，业务可以考虑失败回滚逻辑
            for (List<FlowNode> flowNodes : flowNodeList) {
                if (Objects.isNull(flowNodes) || flowNodes.size() == 0){
                    continue;
                }
                List<Future<FlowResult>> futureList = new ArrayList<>(flowNodes.size());
                CountDownLatch latch = new CountDownLatch(flowNodeList.size());
                for (FlowNode flowNode : flowNodes) {
                    Future<FlowResult> task = executorService.submit(() -> {
                        try {
                            return flowNode.execute(flowContext);
                        } finally {
                            latch.countDown();;
                        }
                    });
                    futureList.add(task);
                }

                latch.await();
                for (Future<FlowResult> task : futureList) {
                    FlowResult flowResult = task.get();
                    if (!flowResult.success){
                        return flowResult;
                    }
                }
            }
            return FlowResult.buildSuccess();
        } catch (Exception e) {
            LOGGER.error("....");
            throw e;
        }
    }

    /**
     * 使用静态内部类单例
     */
    public static FlowEngine get(){
        return SingletonInstance.flowEngine;
    }

    private static class SingletonInstance{
        private static final FlowEngine flowEngine = new FlowEngine();
    }
}
