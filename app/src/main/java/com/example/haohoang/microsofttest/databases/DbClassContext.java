package com.example.haohoang.microsofttest.databases;

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

public class DbClassContext {
    private static final String TAG = DbClassContext.class.toString();
    private List<ClassStudent> classStudents;
    private final String urlGetList = "https://westus.api.cognitive.microsoft.com/face/v1.0/persongroups?start=0";
    public static final DbClassContext instance = new DbClassContext();


    private DbClassContext() {
        this.classStudents = new Vector<>();
    }

    public List<ClassStudent> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(List<ClassStudent> classStudents) {
        this.classStudents = classStudents;
    }

    int count = 0;


    public void getAllGroup() {
        FaceGroupService faceGroupService = NetContext.instance.create(FaceGroupService.class);
        faceGroupService.getAllGroup(urlGetList).enqueue(new Callback<List<ClassStudent>>() {
            @Override
            public void onResponse(Call<List<ClassStudent>> call, Response<List<ClassStudent>> response) {
                classStudents = response.body();

                Log.e(TAG, "onResponse: load hết group");
                EventBus.getDefault().post(new GetDataSuccusEvent(classStudents));
            }

            @Override
            public void onFailure(Call<List<ClassStudent>> call, Throwable t) {
                Log.e(TAG, String.format("onFailure: %s", t.toString()));

                EventBus.getDefault().post(new GetDataFaildedEvent());
            }
        });
    }
}
