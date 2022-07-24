package com.example.designmode.commandLine;

public class Test {

    @org.junit.Test
    public void test(){
        XiaoEr xiaoEr = new XiaoEr();
        jiangsuChef jiangsuChef = new jiangsuChef(new jiangsuCook());
        sichuangChef sichuangChef = new sichuangChef(new sichuangCook());
        zhejiangChef zhejiangChef = new zhejiangChef(new zhejiangCook());
        xiaoEr.add(jiangsuChef);
        xiaoEr.add(sichuangChef);
        xiaoEr.add(zhejiangChef);
        xiaoEr.place();
    }
}
