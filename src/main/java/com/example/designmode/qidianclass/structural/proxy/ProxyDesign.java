package com.example.designmode.qidianclass.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理模式原理：在不改变原始类代码的情况下，通过引入代理类来给原始类附加功能
 * 例子：实现一个性能计数器
 */
public class ProxyDesign {

}

interface UserController{
    UserInfo login();
    UserInfo register();
}

class UserInfo{

}

class IUserController implements UserController{

    @Override
    public UserInfo login() {
        System.out.println("login");
        //处理业务
        return null;
    }

    @Override
    public UserInfo register() {
        System.out.println("register");
        //处理业务
        return null;
    }
}

/**
 * 1、主要就是实现原始类的接口
 * 2、如果原始类没有实现接口呢？那就继承原始类，super去执行原始类的方法
 * 缺点：要实现所有原始类的方法，重复代码太多
 */
class UserControllerProxy implements UserController{

    private IUserController iUserControllerl;

    UserControllerProxy(IUserController iUserController){
        this.iUserControllerl = iUserController;
    }

    /**
     * 这样就没有侵入业务代码
     */
    @Override
    public UserInfo login() {
        Long startTime = System.currentTimeMillis();
        iUserControllerl.login();
        Long endTime = System.currentTimeMillis();
        Long time = endTime - startTime;
        return null;
    }

    @Override
    public UserInfo register() {
        return null;
    }
}


/**
 * 针对上面的缺点：出现了动态代理类
 * 原理：我们不事先为每个原始类编写代理类，而是在运行的时候，动态地创建原始类对应的代理类，然后在系统中用代理类替换掉原始类
 *
 * 代理模式的应用场景：
 * 1、业务系统的非功能性需求开发
 * 2、代理模式在RPC、缓存中的应用
 *  1、RPC框架也可以看成一种代理模式
 *  2、缓存：比如开发一个接口请求的缓存功能，现在有个需求是一个支持缓存，一个支持实时查询，如果开发两个接口就显得成本很高。这个时候就要用到动态代理
 *      如果是用Spring框架来开发的话，就可以在AOP切面中完成接口缓存的功能。在应用启动的时候，我们从配置文件中加载需要支持缓存的接口，以及相应的缓存
 *      策略（比如过期策略等）
 */
class MetricsCollectorProxy{

    public Object createProxy(Object proxiedObject){
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    private class DynamicProxyHandler implements InvocationHandler{

        private Object proxyObject;

        DynamicProxyHandler(Object proxyObject){
            this.proxyObject = proxyObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Long startTime = System.currentTimeMillis();
            Object result = method.invoke(proxyObject, args);
            Long endTime = System.currentTimeMillis();
            Long time = endTime - startTime;
            return result;
        }
    }
}


class Test{
    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        UserController controller = (UserController) proxy.createProxy(new IUserController());
        controller.login();
    }
}



