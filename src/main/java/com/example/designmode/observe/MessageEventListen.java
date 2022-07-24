package com.example.designmode.observe;

/**
 * 发送短信消息
 */
public class MessageEventListen implements EventListen{
    @Override
    public void doSomeIng(String userId) {
        System.out.println("用户" + userId + "发送短信消息");
    }
}
