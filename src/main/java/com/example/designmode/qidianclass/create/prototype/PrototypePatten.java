package com.example.designmode.qidianclass.create.prototype;

/**
 * 如何最快速地clone一个HashMap散列表
 *  场景：如果对象中的数据需要经过复杂的计算才能得到（比如排序、计算哈希值）等，这种情况下，我们就可以利用原型模式，从其他已有对象中直接拷贝得到
 *  1、方法一：递归拷贝对象
 *  2、方法二：序列化和反序列化
 *  3、（推荐）两种方法中和。先采用浅拷贝，再使用深拷贝拷贝里面的引用对象并且替换
 */
public class PrototypePatten {


}
