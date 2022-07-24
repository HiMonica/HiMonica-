package com.example.designmode.factory;

public class EGMRedisServiceImpl implements RedisService{

    private EGM egm;

    @Override
    public String get(String key) {
        return egm.get(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key,value);
    }
}
