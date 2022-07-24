package com.example.designmode.qidianclass.create.factory;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class SimpleFactory {
    public static void main(String[] args) {

    }
}

class RuleConfigSource{
    public void load(String path){

    }
}

class RuleConfigFactory{

    public static Object createByRule(String rule){
        if ("json".equalsIgnoreCase(rule)){
            return "json";
        }else if ("xml".equalsIgnoreCase(rule)){
            return "xml";
        }
        return null;
    }
}

/**
 * 第二种实现
 */
class RuleConfigParserFactory{
    private static final Map<String,Object> store = new ConcurrentHashMap<>();

    static {
        store.put("json","json");
        store.put("xml","xml");
    }

    public static Object create(String rule){
        return store.get(rule);
    }
}

/**
 * 工厂方法
 */
class Dog extends AnimalAbstract{

    @Override
    public void eat() {
        System.out.println("dog eat!");
    }

    @Override
    public void sleep() {
        System.out.println("dog sleep!");
    }

    @Override
    protected String getKey() {
        return "dog";
    }
}

class Cat extends AnimalAbstract{

    @Override
    public void eat() {
        System.out.println("cat eat!");
    }

    @Override
    public void sleep() {
        System.out.println("cat sleep!");
    }

    @Override
    protected String getKey() {
        return "cat";
    }
}

class Fish extends AnimalAbstract{

    @Override
    public void eat() {
        System.out.println("fish eat!");
    }

    @Override
    public void sleep() {
        System.out.println("fish sleep!");
    }

    @Override
    protected String getKey() {
        return "fish";
    }
}

interface Animal{
    void eat();

    void sleep();
}

abstract class AnimalAbstract implements Animal{

    private AnimalFactory animalFactory = AnimalFactory.getInstance();

    AnimalAbstract(){
        animalFactory.register(getKey(), this);
    }

    protected abstract String getKey();
}

@Component
class AnimalFactory{

    private AnimalFactory(){}

    private static class SingleFactory{
        private static AnimalFactory animalFactory = new AnimalFactory();
    }

    private static final Map<String, Animal> factory = new ConcurrentHashMap<>();

    public void register(String key, Animal animal){
        factory.put(key,animal);
    }

    public Animal getAnimal(String key){
        return factory.get(key);
    }

    public static AnimalFactory getInstance(){
        return SingleFactory.animalFactory;
    }
}

