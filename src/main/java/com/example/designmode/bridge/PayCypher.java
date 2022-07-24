package com.example.designmode.bridge;

public class PayCypher implements IPayMode{
    @Override
    public void security(String uId) {
        System.out.println("密码支付验证，验证信息为：" + uId);
    }
}
