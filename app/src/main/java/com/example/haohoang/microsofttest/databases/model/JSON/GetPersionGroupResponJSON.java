package com.example.haohoang.microsofttest.databases.model.JSON;

import com.google.gson.annotations.SerializedName;

/**
 * Created by haohoang on 3/1/17.
 */

public class GetPersionGroupResponJSON {
    @SerializedName("personGroupId")
    public String persongroupid;
    @SerializedName("name")
    public String name;
    @SerializedName("userData")
    public String userdata;

    @Override
    public String toString() {
        return "GetPersionGroupResponJSON{" +
                "persongroupid='" + persongroupid + '\'' +
                ", name='" + name + '\'' +
                ", userdata='" + userdata + '\'' +
                '}';
    }

    public String getPersongroupid() {
        return persongroupid;
    }

    public void setPersongroupid(String persongroupid) {
        this.persongroupid = persongroupid;
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

    public GetPersionGroupResponJSON(String persongroupid, String name, String userdata) {
        this.persongroupid = persongroupid;
        this.name = name;
        this.userdata = userdata;
    }
}
