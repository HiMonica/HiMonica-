package com.example.designmode.bridge;

public class PayFaceMode implements IPayMode{
    @Override
    public void security(String uId) {
        System.out.println("人脸支付进行验证，验证的信息为：" + uId);
    }
}
