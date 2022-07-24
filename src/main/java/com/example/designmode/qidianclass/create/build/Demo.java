package com.example.designmode.qidianclass.create.build;

import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * 与工厂模式有什么区别
 *  1、工厂模式是用来创建不同但是相关类型的对象（继承同一父类或者接口的一组子类）
 *  2、建造者模式是用来创建一种类型的复杂对象，可以通过设置不同的可选参数，"定制化"地创建不同的对象
 */
public class Demo {
}

class ResourcePoolConfig{
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    public ResourcePoolConfig(Builder builder){
        this.name = builder.name;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
        this.maxTotal = builder.maxTotal;
    }
}

class Builder{
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;

    public String name;
    public int maxTotal = DEFAULT_MAX_TOTAL;
    public int maxIdle = DEFAULT_MAX_IDLE;
    public int minIdle = DEFAULT_MIN_IDLE;

    public ResourcePoolConfig build(){
        //校验
        if (StringUtils.isEmpty(name)){
            System.out.println("异常");
        }
        return new ResourcePoolConfig(this);
    }

    public Builder setName(String name){
        if (StringUtils.isEmpty(name)){
            System.out.println("异常");
        }
        this.name = name;
        return this;
    }

    public Builder setMaxTotal(int maxTotal){
        this.maxTotal = maxTotal;
        return this;
    }

}
