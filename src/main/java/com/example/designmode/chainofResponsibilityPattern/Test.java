package com.example.designmode.chainofResponsibilityPattern;

import com.alibaba.fastjson.JSON;

import java.util.Date;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test(){
        Level2AuthLink level2 = new Level2AuthLink("1000013", "王工");
        Level1AuthLink level1 = new Level1AuthLink("1000012", "张经理");
        AuthLink authLink = level2
                .appendNext(level1);

        AuthService.auth("1000013","1000000000");
        System.out.println(JSON.toJSONString(authLink.doAuth("刘宇阳","1000000000",new Date())));
        AuthService.auth("1000012","1000000001");
        authLink.doAuth("刘宇阳","1000000000",new Date());

    }
}
