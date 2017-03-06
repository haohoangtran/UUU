package com.example.haohoang.microsofttest.evenbus;

import com.example.haohoang.microsofttest.classlistdata.ClassStudent;

import java.util.List;

/**
 * Created by tranh on 3/7/2017.
 */

public class GetDataSuccusEvent {
    private List<ClassStudent> classStudents;

    public List<ClassStudent> getClassStudents() {
        return classStudents;
    }

    public GetDataSuccusEvent(List<ClassStudent> classStudents) {
        this.classStudents = classStudents;

    }
}
