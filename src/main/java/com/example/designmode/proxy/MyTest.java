package com.example.designmode.proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class MyTest {

    @Test
    public void test(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classPath:spring-config.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String s = userDao.queryUserInfo("100001");
        log.info("测试结果为:{}",s);
    }
}
