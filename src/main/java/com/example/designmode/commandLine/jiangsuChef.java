package com.example.designmode.commandLine;

public class jiangsuChef implements Chef{

    private Cook cook;

    public jiangsuChef(Cook cook){
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCook();
    }
}
