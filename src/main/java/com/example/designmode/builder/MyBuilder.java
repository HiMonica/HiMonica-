package com.example.designmode.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MyBuilder implements Builder{

    /**
     * 装修清单
     */
    private List<Matter> list = new ArrayList<>();

    private BigDecimal price = BigDecimal.ZERO;

    @Override
    public Builder appendCeil(Matter matter) {
        list.add(matter);
        price.add(matter.price());
        return this;
    }

    @Override
    public Builder appendCoat(Matter matter) {
        return this;
    }
}
