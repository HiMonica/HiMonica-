package com.example.designmode.factory;

public class JDKProxyFactory {

    public static <T> T getProxy(Class cacheClazz, Class<? extends RedisService> redisService) throws Exception {
        JDKInvocationHandler jdkInvocationHandler = new JDKInvocationHandler(redisService.newInstance());
        return null;
    }
}
