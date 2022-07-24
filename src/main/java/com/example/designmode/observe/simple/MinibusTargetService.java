package com.example.designmode.observe.simple;

import com.example.designmode.observe.simple.MinibusTarget;

public class MinibusTargetService implements MinibusTarget {

    /**
     * 只是模拟的摇号规则，并不是实际开发的摇号
     */
    @Override
    public String lottery(String userId) {
        return Math.abs(userId.hashCode()) % 2 == 0 ? "恭喜你，编码".concat(userId).concat("在本次摇号中签")
                : "很遗憾，编码".concat(userId).concat("在本次摇号未中签或摇号资格已过期");
    }
}
