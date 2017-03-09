package com.example.haohoang.microsofttest.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.haohoang.microsofttest.R;
import com.example.haohoang.microsofttest.adapter.ClassListAdapter;
import com.example.haohoang.microsofttest.adapter.StudentListAdapter;
import com.example.haohoang.microsofttest.classlistdata.ClassStudent;
import com.example.haohoang.microsofttest.databases.DbStudentContext;
import com.example.haohoang.microsofttest.networks.NetContext;
import com.example.haohoang.microsofttest.services.PersionService;
import com.example.haohoang.microsofttest.sutudentdata.Student;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentListActivity extends AppCompatActivity {
    private static final String TAG = StudentListActivity.class.toString();
    @BindView(R.id.rv_class_list)
    RecyclerView rvStudentList;
    @BindView(R.id.fab_verify)
    FloatingActionButton btVerify;
    ProgressDialog progress;
    StudentListAdapter studentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        progress = ProgressDialog.show(this, "Loading",
                "Please waiting...", true);
        progress.show();
        addListener();
    }

    private void addListener() {
        btVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentListActivity.this,VerifyActivity.class);
                startActivity(intent);
            }
        });
    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onClassClick(List<Student> c) {// nhận click đang lỗi
        Log.e(TAG, "onClassClick: Vào bên nhận");
        progress.dismiss();
        StudentListAdapter studentListAdapter=new StudentListAdapter(this);
        rvStudentList.setAdapter(studentListAdapter);
        rvStudentList.setLayoutManager(new GridLayoutManager(this,2));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
