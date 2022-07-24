package com.example.designmode.payDemo;

public class VirtualWallet {

    private String id;

    //默认为0
    private Double balance = 0.0;

    VirtualWallet(String id){
        this.id = id;
    }

    /**
     * 入虚拟钱包
     */
    public Boolean add(Double money){
        if (money < 0){
            //异常
            return false;
        }
        this.balance += money;
        return true;
    }

    /**
     * 出虚拟钱包
     */
    public Boolean subtract(Double money){
        if (money < 0){
            //异常
            return false;
        }
        this.balance -= money;
        return true;
    }

    public Double getBalance(){
        return this.balance;
    }
}
