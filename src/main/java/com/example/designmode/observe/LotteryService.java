package com.example.designmode.observe;

import com.example.designmode.observe.simple.LotteryResult;

public abstract class LotteryService implements Lottery{

    private EventManger eventManger;

    LotteryService(){
        EventEnum.AllEnum();
        eventManger = new EventManger();
        eventManger.subscribe(EventEnum.MQ,new MQEventListen());
        eventManger.subscribe(EventEnum.Message,new MessageEventListen());
    }

    public LotteryResult draw(String userId) {
        LotteryResult lotteryResult = doDraw(userId);
        eventManger.advice(EventEnum.MQ,userId);
        eventManger.advice(EventEnum.Message,userId);
        return lotteryResult;
    }

}
