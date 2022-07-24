package com.example.designmode.prototype;

import java.util.*;

public class RandomUtils {

    public static Topic random(Map<String ,String> option,String key){
        //先将答案打乱，然后遍历找到对应的正确答案
        Set<String> keySet = option.keySet();
        ArrayList<String> keyList = new ArrayList<>(keySet);
        //对数组进行混排操作
        Collections.shuffle(keyList);
        Map<String ,String> newOption = new HashMap<>();
        int index = 0;
        String newKey = "";
        for (String next : keySet) {
            String randomKey = keyList.get(index++);
            if (key.equals(next)){
                newKey = randomKey;
            }
            newOption.put(randomKey,option.get(next));
        }
        return new Topic(newOption,newKey);
    }
}
