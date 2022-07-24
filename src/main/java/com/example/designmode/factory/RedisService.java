package com.example.designmode.factory;

public interface RedisService {

    String get(String key);

    void set(String key,String value);
}
