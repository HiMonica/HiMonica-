package com.example.designmode.strategy.并发责任链;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工厂，获取自定义的线程池
 *
 * @author julu
 * @date 2022/9/21 22:19
 */
public class ThreadPoolExecutorFactory {

    /**
     * 没有线程工厂的线程池
     */
    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
            1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000),
            new ThreadPoolExecutor.AbortPolicy());

}
