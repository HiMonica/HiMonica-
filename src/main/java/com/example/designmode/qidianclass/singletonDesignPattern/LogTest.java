package com.example.designmode.qidianclass.singletonDesignPattern;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 思考这个日志程序存在的问题
 * 1、所有日志都写在同一个文件，每一次都创建一次Logger对象，多线程同时运行的时候会出现日志覆盖问题
 * 解决：你会说加锁，但是不行的，因为创建了两个对象，不同的对象锁是不一样的，不能解决问题，实际上解决这个问题需要加类级别的锁如下代码
 * 2、所以要保证单例
 *   单例的好处
 *      1、只有一个对线，节省了内存空间
 *      2、节省系统文件句柄
 * 如何实现一个单例，需要考虑的问题：
 *  1、构造函数需要private
 *  2、创建对象考虑线程安全问题
 *  3、是否延迟加载
 *  4、考虑getInstance()性能是否高（是否加锁）
 */
public class LogTest {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.test();
    }
}

class Logger{

    private FileWriter writer;

    public Logger() {
        //true表示追加写
        try {
            writer = new FileWriter(new File("/Users/liuyuyang/logs/test.txt"),true);
        } catch (IOException e) {
            System.out.println("异常");
        }
    }

    public void log(String message) {
        try {
            synchronized (Logger.class){ //类级别的锁
                writer.write(message);
            }
        } catch (IOException e) {
            System.out.println("异常");
        }
    }
}

class UserService{

    private Logger log = new Logger();

    public void test(){
        log.log("这是一条日志");
        System.out.println("写入成功");
    }
}


/**
 * 饿汉式：线程安全，不支持延迟加载
 */
class Hungry{

    private static final Hungry hungry = new Hungry();

    private Hungry(){

    }

    public static Hungry getInstance(){
        return hungry;
    }
}

/**
 * 懒汉式：线程不安全（需要加锁），支持延迟加载
 */
class Lazy{

    private static Lazy lazy = null;

    private Lazy(){

    }

    public static Lazy getInstance(){
        if (lazy == null){
            lazy = new Lazy();
        }
        return lazy;
    }
}

/**
 * 双重检测
 */
class Check{

    private volatile static Check check = null;

    private Check(){

    }

    public static Check getInstance(){
        if (check == null){
            synchronized (Check.class){ //此处为类级别的锁
                if (check == null){
                    check = new Check();
                }
            }
        }
        return check;
    }
}

/**
 * 静态内部类
 */
class StaticClass{

    private StaticClass(){

    }

    private static class Clazz{
        private static final StaticClass staticClass = new StaticClass();
    }

    public static StaticClass getInstance(){
        return Clazz.staticClass;
    }
}

/**
 * 枚举
 */
enum ClassEnum{
    CLASSENUM;
}
