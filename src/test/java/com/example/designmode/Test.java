package com.example.designmode;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class Test extends DesignmodeApplicationTests{

    private static String appName = null;

    @org.junit.jupiter.api.Test
    public void test(){

    }

    public static void mytest(){
        if (appName != null){
            return;
        }
    }

    static Map<String, List<String>> store1 = new HashMap<>();

    static Map<String, List<String>> store2 = new HashMap<>();

    static {
        List<String> strings1 = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            strings1.add("corpId131231dw412412312312" + i);
        }
        store1.put("1", strings1);
        List<String> strings2 = new ArrayList<>();
        for (int i = 0; i < 60000; i++) {
            strings2.add("corpId131231dw412412312312" + i);
        }
        store2.put("2", strings2);
    }

    @org.junit.Test
    public void test1(){
        List<String> strings1 = store1.get("1");
        for (String string : strings1) {
            System.out.print(string.hashCode() % 100);
        }

        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");

        List<String> strings2 = store2.get("2");
        for (String s : strings2) {
            System.out.print(s.hashCode() % 100);
        }
    }

}
