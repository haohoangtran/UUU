package com.example.haohoang.microsofttest;

import android.util.Log;

import com.example.haohoang.microsofttest.classlistdata.ClassStudent;
import com.example.haohoang.microsofttest.evenbus.GetDataFaildedEvent;
import com.example.haohoang.microsofttest.evenbus.GetDataSuccusEvent;
import com.example.haohoang.microsofttest.networks.NetContext;
import com.example.haohoang.microsofttest.services.FaceGroupService;
import com.example.haohoang.microsofttest.services.PersionService;
import com.example.haohoang.microsofttest.sutudentdata.Student;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Vector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tranh on 3/7/2017.
 */

public class DbContext {
    private static final String TAG = DbContext.class.toString();
    private List<ClassStudent> classStudents;
    private final String urlGetList = "https://westus.api.cognitive.microsoft.com/face/v1.0/persongroups?start=0";
    public static final DbContext instance = new DbContext();


    private DbContext() {
        this.classStudents = new Vector<>();
    }

    public List<ClassStudent> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(List<ClassStudent> classStudents) {
        this.classStudents = classStudents;
    }

    int count = 0;

    private void getAllStudentInGroup(final ClassStudent c) {
        PersionService persionService = NetContext.instance.create(PersionService.class);
        persionService.getAllPersonInGroup(c.getPersongroupid()).enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                List<Student> s = response.body();
                c.setStudents(s);
                if (count == classStudents.size() - 1)
                    EventBus.getDefault().post(new GetDataSuccusEvent(classStudents));
                else
                    count++;
                Log.e(TAG, "onResponse: Gửi");
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                EventBus.getDefault().post(new GetDataFaildedEvent());
                Log.e(TAG, "onFailure: GỬi ");
            }
        });
    }

    public void getAllGroup() {
        FaceGroupService faceGroupService = NetContext.instance.create(FaceGroupService.class);
        faceGroupService.getAllGroup(urlGetList).enqueue(new Callback<List<ClassStudent>>() {
            @Override
            public void onResponse(Call<List<ClassStudent>> call, Response<List<ClassStudent>> response) {
                classStudents = response.body();
                for (int i = 0; i < classStudents.size(); i++) {
                    getAllStudentInGroup(classStudents.get(i));
                }
                Log.e(TAG, "onResponse: ccccc");
            }

            @Override
            public void onFailure(Call<List<ClassStudent>> call, Throwable t) {
                Log.e(TAG, String.format("onFailure: %s", t.toString()));

                EventBus.getDefault().post(new GetDataFaildedEvent());
            }
        });
    }
}
