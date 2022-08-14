package com.example.designmode.qidianclass.structural.bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 桥接模式：组合
 */
public class BridgeDemo {
    public static void main(String[] args) {
        TelephoneMsg msg = new TelephoneMsg(new ArrayList<>());
        Notification notification = new UrgencyNotifycation(msg);
        notification.notify("lalala");
    }
}

interface MsgSend{
    void send(String msg);
}

class TelephoneMsg implements MsgSend{

    private List<String> telephone;

    TelephoneMsg(List<String> telephone){
        this.telephone = telephone;
    }

    @Override
    public void send(String msg) {
        System.out.println("telephone msg");
    }
}

class EmailMsg implements MsgSend{

    @Override
    public void send(String msg) {
        System.out.println("email msg");
    }
}

abstract class Notification{
    protected MsgSend msgSend;

    Notification(MsgSend msgSend){
        this.msgSend = msgSend;
    }

    public abstract void notify(String massage);
}

class SevereNotification extends Notification{

    SevereNotification(MsgSend msgSend) {
        super(msgSend);
    }

    @Override
    public void notify(String massage) {
        msgSend.send(massage);
    }
}

class UrgencyNotifycation extends Notification{

    UrgencyNotifycation(MsgSend msgSend) {
        super(msgSend);
    }

    @Override
    public void notify(String massage) {
        msgSend.send(massage);
    }
}
