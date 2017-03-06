package com.example.haohoang.microsofttest.databases.model.bodies;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haohoang on 3/1/17.
 */

public class AddNewGroupBody {

    @SerializedName("name")
    public String name;
    @SerializedName("userData")
    public String userdata;

    @Override
    public String toString() {
        return "NewFaceGroupResponJSON{" +
                "name='" + name + '\'' +
                ", userdata='" + userdata + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserdata() {
        return userdata;
    }

    public void setUserdata(String userdata) {
        this.userdata = userdata;
    }

    public AddNewGroupBody(String name, String userdata) {

        this.name = name;
        this.userdata = userdata;
    }
}
