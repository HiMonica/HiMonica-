package com.example.designmode.qidianclass.create.singletonDesignPattern;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 1、如何理解单例模式中的唯一性？
 *  1、定义：一个类只允许创建唯一一个对象，那这个类就是一个单例类，这种设计模式就叫做单例设计模式（范围：是指线程内只允许创建一个对象？还是指进程内只允许创建一个对象？答案：进程）
 * 2、如何实现线程唯一的单例？
 * 3、如何实现集群环境下的单例？
 * 4、如何实现一个多例模式？
 */
public class SingleAdvance {

}

/**
 * 实现线程唯一的单例：
 *  1、其实很简单可以通过一个HashMap来存储对象，其中key是线程ID，value是对象
 *  2、ThreadLocal工具类：底层实现原理也是基于HashMap
 */
class IdGenerator{

    private static final ConcurrentHashMap<Long, IdGenerator> hashMap = new ConcurrentHashMap<>();

    private IdGenerator(){

    }

    public static IdGenerator getInstance(){
        Long id = Thread.currentThread().getId();
        //putIfAbsent：如果相同就放弃还是用原来的值
        hashMap.putIfAbsent(id,new IdGenerator());
        return hashMap.get(id);
    }
}

/**
 * 如何实现集群环境下的单例？
 *  1、集群相当于多个进程构成的一个集合，"集群唯一"：进程内唯一，进程间也唯一，也就是说，不同的进程间共享同一个对象，不能创建同一个类的多个对象
 *  怎么实现：我们需要把这个单例对象序列化并存储到外部共享存储区（比如文件）。进程在使用这个单例对象的时候，需要先从外部共享存储区中将它读取到内存
 *  并反序列化成对象，然后再使用，使用完之后还需要再存储回外部共享存储区
 *  为了保证任何时刻，在进程间都只有一份对象存在，一个进程在获取到对象之后，需要对对象加锁，避免其他进程再将其获取。在进程使用完这个对象之后，还需要显式
 *  地将对象从内存中删除，并且释放对象的加锁
 */

