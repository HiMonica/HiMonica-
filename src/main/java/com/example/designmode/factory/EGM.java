package com.example.designmode.factory;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class EGM {

    private Map<String,String> store = new HashMap<>();

    public String get(String key){
        log.info("EGM取出key:{}",key);
        return store.get(key);
    }

    public void set(String key,String value){
        log.info("EGM存入key:{},value:{}",key,value);
        store.put(key,value);
    }
}
