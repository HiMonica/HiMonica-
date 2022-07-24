package com.example.designmode.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChoiceQuestion {
    private String name;
    private Map<String,String> option;
    private String key;

}
