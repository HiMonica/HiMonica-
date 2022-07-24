package com.example.designmode.payDemo;

public interface PayService {

    Result pay(String userId,Double money);

    Result transfer(String userId,String toUserId);

    Result withdraw(String userId,String card);
}
