package com.example.designmode.factory;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class RedisUtils {

    private Map<String,String> store = new HashMap<>();

    public void set(String key,String value){
        log.info("Redis中放入数据key:{},value{}",key,value);
        store.put(key,value);
    }

    public String get(String key){
        log.info("Redis中获取数据key:{}",key);
        return store.get(key);
    }
}
