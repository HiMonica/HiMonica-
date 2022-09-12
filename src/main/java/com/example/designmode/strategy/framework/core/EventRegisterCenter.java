package com.example.designmode.strategy.framework.core;

import com.example.designmode.strategy.framework.base.IEventHandler;
import javafx.application.Application;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author julu
 * @date 2022/9/12 23:03
 */
@Component
public class EventRegisterCenter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Map<Class, List<IEventHandler>> eventHandlerMap = new ConcurrentHashMap<>();

    private final Object objectMonitor = new Object();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init(){
        Map<String, IEventHandler> map = applicationContext.getBeansOfType(IEventHandler.class);

        for (IEventHandler handler : map.values()) {
            Class<?> eventClaz = getEventFromEventHandler(handler.getClass());

        }
    }

    /**
     * 获取事件处理器
     */
    public List<IEventHandler> getEventHandlers(Class<?> eventClass){
        return eventHandlerMap.get(eventClass);
    }


    /**
     * 注册事件对应的处理器
     */
    public void register(Class<?> eventClz, IEventHandler eventHandler){
        List<IEventHandler> handlers = getEventHandlers(eventClz);

        //说明没有初始化
        if (handlers == null){
            synchronized (objectMonitor){
                handlers = getEventHandlers(eventClz);
                if (handlers == null){
                    handlers = new LinkedList<>();
                }
            }
        }
        handlers.add(eventHandler);

        //是否需要重新排序
        if (eventHandler.order() < Integer.MAX_VALUE){
            handlers = handlers.stream()
                    .sorted(Comparator.comparing(IEventHandler::order))
                    .collect(Collectors.toList());
        }

        eventHandlerMap.put(eventClz, handlers);
    }

    /**
     * 从事件处理器中获取处理器监听的事件
     */
    private Class<?> getEventFromEventHandler(Class<?> eventHandler){
        Method[] methods = eventHandler.getDeclaredMethods();
        for (Method method : methods) {
            if (StringUtils.pathEquals("handler", method.getName()) && !method.isBridge()){
                return method.getParameterTypes()[0];
            }
        }
        throw new RuntimeException("Failed" + eventHandler.getSimpleName());
    }
}
