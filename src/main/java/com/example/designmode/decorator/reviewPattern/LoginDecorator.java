package com.example.designmode.decorator.reviewPattern;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginDecorator extends SsoDecorator{

    LoginDecorator(HandlerInterceptor handlerInterceptor){
        super(handlerInterceptor);
    }

    private HandlerInterceptor getInterceptor(){
        HandlerInterceptor handlerInterceptor = interceptor;
        if (handlerInterceptor == null){
            System.out.println("报错");
        }
        return handlerInterceptor;
    }

//    public boolean preHandle(String request, String response, Object handler) throws Exception {
//        return super.preHandle(request,response,handler);
//    }
}
