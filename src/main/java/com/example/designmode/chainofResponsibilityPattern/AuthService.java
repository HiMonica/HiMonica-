package com.example.designmode.chainofResponsibilityPattern;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务类：模拟审批和查询审批结果的类
 */
public class AuthService {

    private static Map<String, Date> store = new ConcurrentHashMap<>();

    public static Date queryAuthInfo(String uId, String orderId){
        if (!store.containsKey(uId.concat(orderId))){
            return null;
        }
        return store.get(uId.concat(orderId));
    }

    public static void auth(String uId, String orderId){
        store.put(uId.concat(orderId), new Date());
    }
}
