package com.example.haohoang.microsofttest.evenbus;

/**
 * Created by DUC THANG on 3/9/2017.
 */

public class AddNewClassEvent {
    private String msg;

    public AddNewClassEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
