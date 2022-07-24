package com.example.designmode.bridge;

public class PayFingerprintMode implements IPayMode{
    @Override
    public void security(String uId) {
        System.out.println("指纹支付进行验证，验证信息为：" + uId);
    }
}
