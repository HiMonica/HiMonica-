package com.example.designmode.chainofResponsibilityPattern;

import java.util.Date;

public class Level1AuthLink extends AuthLink{

    Level1AuthLink(String levelUserId, String levelUsername) {
        super(levelUserId, levelUsername);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(uId, orderId);
        if (date == null){
            return new AuthInfo("0001","单号：",orderId,"状态：待一级负责人审批",levelUsername);
        }
        AuthLink next = super.next;
        if (next == null){
            return new AuthInfo("0000","单号",orderId,"状态：一级负责人审批完成","时间：",format.format(date),"审批人：",levelUsername);
        }
        return next.doAuth(uId,orderId,authDate);
    }
}
