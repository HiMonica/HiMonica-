package com.example.designmode.builder;

public interface Builder {

    /**
     * 吊顶选择
     */
    Builder appendCeil(Matter matter);

    /**
     * 涂料选择
     */
    Builder appendCoat(Matter matter);

}
