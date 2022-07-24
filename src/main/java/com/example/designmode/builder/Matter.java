package com.example.designmode.builder;

import java.math.BigDecimal;

public interface Matter {

    /**
     * 使用的场景
     */
    String scene();

    /**
     * 品牌
     */
    String brand();

    /**
     * 型号
     */
    String model();

    /**
     * 价格
     */
    BigDecimal price();

    /**
     * 描述
     */
    String desc();
}
