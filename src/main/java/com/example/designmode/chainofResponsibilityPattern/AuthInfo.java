package com.example.designmode.chainofResponsibilityPattern;

public class AuthInfo {
    private String code;
    private String info = "";
    AuthInfo(String code, String ...infos){
        this.code = code;
        for (String info : infos) {
            this.info = this.info.concat(info);
        }
    }
}
