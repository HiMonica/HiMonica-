package com.example.designmode.observe;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 相关事件的枚举
 */
@AllArgsConstructor
public enum EventEnum {
    MQ,
    Message
    ;

    private static List<EventEnum> store = new ArrayList<>();

    /**
     * 提供一个枚举的遍历方法
     */
    public static void AllEnum(){
        Collections.addAll(store, EventEnum.values());
    }

    /**
     * 移除某个枚举的方法
     */
    public static void removeEnum(EventEnum eventEnum){
        store.remove(eventEnum);
    }

    public static List<EventEnum> getStore(){
        return store;
    }
}
