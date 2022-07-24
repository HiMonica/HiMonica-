package com.example.designmode.decorator.pattern;

import org.springframework.web.servlet.HandlerInterceptor;

public class SsoDecorator implements HandlerInterceptor {

    private HandlerInterceptor handlerInterceptor;

    private SsoDecorator(){}

    public SsoDecorator(HandlerInterceptor handlerInterceptor){
        this.handlerInterceptor = handlerInterceptor;
    }

    public boolean preHandle(String request, String response, Object handler) {
        String ticket = request.substring(1,8);
        return ticket.equals("success");
    }
}
