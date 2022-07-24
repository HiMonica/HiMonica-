package com.example.designmode.decorator.noPattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginSsoDecorator extends SsoInterceptor{

    private static Map<String,String> authMap = new ConcurrentHashMap<>();

    static {
        authMap.put("huahua","queryUserInfo");
        authMap.put("doudou","queryUserInfo");
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        String ticket = request.substring(1,8);
        boolean isSuccess = ticket.equals("success");
        if (!isSuccess){
            return false;
        }
        String userId = request.substring(8);
        String method = authMap.get(userId);
        //模拟方法校验
        return "queryUserInfo".equals(method);
    }
}
