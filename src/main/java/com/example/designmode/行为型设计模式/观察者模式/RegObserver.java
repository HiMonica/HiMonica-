package com.example.designmode.行为型设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author julu
 * @date 2022/9/18 16:56
 */
public interface RegObserver {

    void handleRegSuccess(long userId);
}

interface PromotionService{

    void issueNewUserExperienceCash(Long userId);
}

interface NotificationService{

    void sendInboxMessage(Long userId, String message);
}

class RegPromotionObserver implements RegObserver{

    private PromotionService promotionService;

    @Override
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}

class RegNotificationObserver implements RegObserver{

    private NotificationService notificationService;

    @Override
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, "Welcome...");
    }
}

interface UserService{

    Long register(String telephone, String password);
}

class UserController{
    private UserService userService;

    private List<RegObserver> regObservers = new ArrayList<>();

    public void setRegObservers(List<RegObserver> regObservers) {
        this.regObservers = regObservers;
    }

    public Long register(String telephone, String password){

        Long userId = userService.register(telephone, password);

        for (RegObserver regObserver : regObservers) {
            regObserver.handleRegSuccess(userId);
        }

        return userId;
    }
}




