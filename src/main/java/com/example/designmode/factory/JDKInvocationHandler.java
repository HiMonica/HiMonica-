package com.example.designmode.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {

    private RedisService redisService;

    JDKInvocationHandler(RedisService redisService){
        this.redisService = redisService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        return RedisService.class.getMethod(method.getName(),ClassLoaderUtils.getClazzByArgs(args).invoke(redisService,args));
        return null;
    }

}
