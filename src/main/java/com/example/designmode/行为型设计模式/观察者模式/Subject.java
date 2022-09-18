package com.example.designmode.行为型设计模式.观察者模式;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author julu
 * @date 2022/9/18 16:45
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(String message);
}

interface Observer{

    void update(String message);
}

class ConcreteSubject implements Subject{
    private List<Observer> observers = new ArrayList<>();


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

class ConcreteObserverOne implements Observer{

    @Override
    public void update(String message) {
        //消息发送
    }
}

class ConcreteObserverTwo implements Observer{

    @Override
    public void update(String message) {
        //消息发送
    }
}


