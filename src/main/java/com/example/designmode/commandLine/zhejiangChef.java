package com.example.designmode.commandLine;

public class zhejiangChef implements Chef{

    private Cook cook;

    zhejiangChef(Cook cook){
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCook();
    }
}
