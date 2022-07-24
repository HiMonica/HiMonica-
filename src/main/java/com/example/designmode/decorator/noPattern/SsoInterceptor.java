package com.example.designmode.decorator.noPattern;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 模拟单点登陆，所以request和response是模拟的数据，真实情况下需要获取cookie解析
 */
public class SsoInterceptor implements HandlerInterceptor {

    public boolean preHandle(String request, String response, Object handler) {
        //模拟获取cookie
        String ticket = request.substring(1,8);
        //模拟校验
        return ticket.equals("success");
    }
}
