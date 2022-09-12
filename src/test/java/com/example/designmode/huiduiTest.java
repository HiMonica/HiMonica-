package com.example.designmode;

import cn.hutool.Hutool;
import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.SimpleAspect;
import cn.hutool.core.swing.RobotUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.lang.Nullable;

import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class huiduiTest {

    public static void main(String[] args) {
        Set<Class<?>> allUtils = Hutool.getAllUtils();
        System.out.println(JSON.toJSONString(allUtils));
        SimpleAspect simpleAspect = new SimpleAspect();
        ProxyUtil.proxy(huiduiTest.class,simpleAspect);
    }

    @Test
    public void test1(){
        int a = -1;


    }
}

class MyLock extends ReentrantLock{

    public void test(){
        lock();
    }
}
