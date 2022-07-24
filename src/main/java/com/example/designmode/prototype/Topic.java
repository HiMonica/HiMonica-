package com.example.designmode.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class Topic {

    //答案
    private Map<String,String> option;

    //答案（A，B，C，D）
    private String key;
}
