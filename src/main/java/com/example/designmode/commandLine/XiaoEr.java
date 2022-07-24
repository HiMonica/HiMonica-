package com.example.designmode.commandLine;

import java.util.ArrayList;
import java.util.List;

public class XiaoEr {

    private List<Chef> list = new ArrayList<>();

    public void add(Chef chef){
        list.add(chef);
    }

    public synchronized void place(){
        for (Chef chef : list) {
            chef.cook();
        }
        list.clear();
    }
}
