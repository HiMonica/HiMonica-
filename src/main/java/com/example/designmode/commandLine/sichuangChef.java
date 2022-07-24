package com.example.designmode.commandLine;

public class sichuangChef implements Chef{

    private Cook cook;

    sichuangChef(Cook cook){
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCook();
    }
}
