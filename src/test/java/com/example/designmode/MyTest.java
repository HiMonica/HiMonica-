package com.example.designmode;

import java.util.*;

public class MyTest {

    public static String test(String str,int k){
        String[] strs = str.split(" ");
        Map<String,Integer> store = new HashMap<>();
        for (int i = 0;i < strs.length;i++){
            if(!store.containsKey(strs[i])){
                store.put(strs[i],1);
            }else{
                store.put(strs[i],store.get(strs[i]) + 1);
            }
        }
        StringBuffer result = new StringBuffer();
        int i = 0;
        while(i < k){
            int max = 0;
            String maxString = "";
            for(Map.Entry<String,Integer> entry : store.entrySet()){
                if(entry.getValue() > max){
                    maxString = entry.getKey();
                }
            }
            result.append(maxString + " ");
            store.remove(maxString);
            i++;
        }
        return result.toString();
    }

    public static void main(String[] args){
        List<Animal> animal = new ArrayList<>();
        List<Cat> cat = new ArrayList<>();
        List<Garfield> garfield = new ArrayList<>();
        animal.add(new Animal());
        cat.add(new Cat());
        garfield.add(new Garfield());
//        List<? extends Cat> extendsCatFromAnimal = animal;
        List<? super Cat> superCatFromAnimal = animal;
        List<? extends Cat> extendsCatFromCat = cat;
        List<? super Cat> superCatFromCat = cat;
        List<? extends Cat> extendsCatFromGarfield = garfield;
//        List<? super Cat> superCatFromGarfield = garfield;

//        extendsCatFromCat.add(new Animal());
//        extendsCatFromCat.add(new Cat());
//        extendsCatFromCat.add(new Garfield());
//        superCatFromCat.add(new Animal());
        superCatFromCat.add(new Cat());
        superCatFromCat.add(new Garfield());


    }
}

class Animal{

}

class Cat extends Animal{

}

class Garfield extends Cat{

}


