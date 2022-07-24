package com.example.designmode.chainofResponsibilityPattern;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AuthLink {

    protected SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    protected String levelUserId;//级别人员ID

    protected String levelUsername;//级别人员姓名

    protected AuthLink next;//责任链

    private List<AuthLink> authLink = new ArrayList();

    AuthLink(String levelUserId, String levelUsername){
        this.levelUserId = levelUserId;
        this.levelUsername = levelUsername;
    }

    public AuthLink next(){
        return next;
    }

    //这里也可以用链表
    public AuthLink appendNext(AuthLink link){
        this.next = next;
        return this;
    }

    public AuthLink add(AuthLink link){
        authLink.add(link);
        return this;
    }

    public List<AuthLink> getAuthLink() {
        return authLink;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);
}
