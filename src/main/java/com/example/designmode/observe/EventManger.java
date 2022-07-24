package com.example.designmode.observe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 事件处理类
 */
public class EventManger {

    Map<EventEnum,List<EventListen>> listens = new HashMap<>();

    EventManger(){
        for (EventEnum eventEnum : EventEnum.getStore()) {
            this.listens.put(eventEnum,new ArrayList<>());
        }
    }

    /**
     * 多订阅
     * @param eventEnumList 事件类型
     * @param eventListen 监听事件
     */
    public void subscribe(List<EventEnum> eventEnumList,EventListen eventListen){
        eventEnumList.stream().forEach(eventEnum -> {
            List<EventListen> eventListens = listens.get(eventEnum);
            eventListens.add(eventListen);
        });
    }

    /**
     * 单订阅
     * @param eventEnum 事件类型
     * @param eventListen 监听事件
     */
    public void subscribe(EventEnum eventEnum,EventListen eventListen){
        List<EventListen> eventListens = listens.get(eventEnum);
        eventListens.add(eventListen);
    }


    /**
     * 取消订阅
     * @param eventEnum 事件类型
     * @param eventListen 监听事件
     */
    public void unsubscribe(EventEnum eventEnum,EventListen eventListen){
        List<EventListen> eventListens = listens.get(eventEnum);
        eventListens.remove(eventListen);
    }

    public void advice(EventEnum eventEnum,String userId){
        List<EventListen> eventListens = listens.get(eventEnum);
        for (EventListen listen : eventListens) {
            listen.doSomeIng(userId);
        }
    }
}
