package com.example.designmode.observe;

/**
 * MQ事件
 */
public class MQEventListen implements EventListen{

    @Override
    public void doSomeIng(String userId) {
        System.out.println("用户" + userId + "发送MQ消息");
    }
}
