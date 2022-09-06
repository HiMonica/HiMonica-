package com.example.designmode.qidianclass.structural.facade;

/**
 * @author julu
 * @date 2022/9/6 23:17
 */

/**
 * 为什么要使用门面模式：
 * 1、比如有四个接口a，b，c，d，我们有一个应用场景需要依次调用a、b、c，这样可以将a、b、c包装成一个接口
 * 为什么要包装成一个接口呢，因为Mtop调用会耗时，但是又不能并发调用，这样我们就需要将三个接口合并，减少接口调用的耗时
 */
public class Facade {
}
