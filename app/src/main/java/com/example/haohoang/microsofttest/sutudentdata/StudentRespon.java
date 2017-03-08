package com.example.haohoang.microsofttest.sutudentdata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tranh on 3/9/2017.
 */

public class StudentRespon {
    @SerializedName("personId")
    private String personid;
    @SerializedName("name")
    private String name;
    @SerializedName("userData")
    private String userdata;

    public StudentRespon(String personid, String name, String userdata) {
        this.personid = personid;
        this.name = name;
        this.userdata = userdata;
    }

    public String getPersonid() {
        return personid;
    }

    public String getName() {
        return name;
    }

    public String getUserdata() {
        return userdata;
    }
}
