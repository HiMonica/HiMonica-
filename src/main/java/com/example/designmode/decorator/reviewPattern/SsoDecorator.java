package com.example.designmode.decorator.reviewPattern;

import org.springframework.web.servlet.HandlerInterceptor;

public class SsoDecorator implements HandlerInterceptor {

    protected HandlerInterceptor interceptor;

    SsoDecorator(){}

    SsoDecorator(HandlerInterceptor interceptor){
        this.interceptor = interceptor;
    }

    public boolean preHandle(String request, String response, Object handler) throws Exception {
        //todo 将封装好的request中的信息拉去出来并且进去逻辑的处理
        request.substring(0,5);
        return true;
    }
}
