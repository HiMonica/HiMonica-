package com.example.designmode.decorator.pattern;

import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginDecorator extends SsoDecorator{

    private static Map<String,String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua","queryUserInfo");
        authMap.put("doudou","queryUserInfo");
    }

    public LoginDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
//        boolean isSuccess = super.preHandle(request, response, handler);
//        if (!isSuccess){
//            return false;
//        }
        String userId = request.substring(8);
        String method = authMap.get(userId);
        return "queryUserInfo".equals(method);
    }
}
