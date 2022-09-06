package com.example.designmode;

import cn.hutool.Hutool;
import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.SimpleAspect;
import cn.hutool.core.swing.RobotUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Set;

public class huiduiTest {

    public static void main(String[] args) {
        Set<Class<?>> allUtils = Hutool.getAllUtils();
        System.out.println(JSON.toJSONString(allUtils));
        SimpleAspect simpleAspect = new SimpleAspect();
        ProxyUtil.proxy(huiduiTest.class,simpleAspect);
    }

    @Test
    public void test1(){
        Class<huiduiTest> clazz = huiduiTest.class;
        String simpleName = clazz.getName();
        System.out.println(simpleName);
    }
}

class User{

}
