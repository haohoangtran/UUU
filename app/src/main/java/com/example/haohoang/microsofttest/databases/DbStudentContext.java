package com.example.haohoang.microsofttest.databases;

import android.util.Log;

import com.example.haohoang.microsofttest.evenbus.GetDataFaildedEvent;
import com.example.haohoang.microsofttest.networks.NetContext;
import com.example.haohoang.microsofttest.services.PersionService;
import com.example.haohoang.microsofttest.sutudentdata.Student;
import com.example.haohoang.microsofttest.sutudentdata.StudentRespon;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Vector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tranh on 3/9/2017.
 */

public class DbStudentContext {
    public static final DbStudentContext instance = new DbStudentContext();
    private final String TAG = DbStudentContext.class.toString();
    private List<Student> students;
    private List<StudentRespon> studentRespon;
    private String idGroup;

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    private DbStudentContext() {
        this.students = new Vector<>();
        studentRespon=new Vector<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void getAllStudentInGroup() {
        students.clear();
        studentRespon.clear();
        PersionService persionService = NetContext.instance.create(PersionService.class);
        persionService.getAllPersonInGroup(idGroup).enqueue(new Callback<List<StudentRespon>>() {
            @Override
            public void onResponse(Call<List<StudentRespon>> call, Response<List<StudentRespon>> response) {
                studentRespon = response.body();
                for (int i = 0; i < studentRespon.size(); i++) {
                    students.add(new Student(studentRespon.get(i)));
                }
                EventBus.getDefault().postSticky(students);
                Log.e(TAG, "onResponse: Thành");

            }

            @Override
            public void onFailure(Call<List<StudentRespon>> call, Throwable t) {
                EventBus.getDefault().post(new GetDataFaildedEvent());
                ;
            }
        });
    }
}
