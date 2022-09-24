package com.example.designmode.strategy.并发责任链;

/**
 * 业务执行接口
 *
 * @author julu
 * @date 2022/9/21 22:52
 */
public interface FlowExecute<C, R> {

    /**
     * 参数化校验
     * @param context
     * @return
     */
    Result checkParam(C context);

    /**
     * 前置处理
     * @param context
     * @return
     */
    Result beforeProcess(C context);

    /**
     * 业务处理
     * @param context
     * @return
     */
    void process(C context) throws Exception;

    /**
     * 后置处理
     * @param context
     * @return
     */
    Result afterProcess(C context);
}
