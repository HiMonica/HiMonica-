package com.example.designmode.factory;

public class IIRRedisServiceImpl implements RedisService{

    private IIR iir;

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key,value);
    }
}
