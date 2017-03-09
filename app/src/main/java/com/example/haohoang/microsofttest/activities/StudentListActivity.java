package com.example.haohoang.microsofttest.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.haohoang.microsofttest.DbContext;
import com.example.haohoang.microsofttest.R;
import com.example.haohoang.microsofttest.adapter.StudentListAdapter;
import com.example.haohoang.microsofttest.classlistdata.ClassStudent;
import com.example.haohoang.microsofttest.networks.NetContext;
import com.example.haohoang.microsofttest.services.PersionService;
import com.example.haohoang.microsofttest.sutudentdata.Student;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentListActivity extends AppCompatActivity {
    private static final String TAG = StudentListActivity.class.toString();
    public static List<Student> students;
    @BindView(R.id.rv_student_list)
    RecyclerView rvStudentList;
    ProgressDialog progress;
    StudentListAdapter studentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        progress = ProgressDialog.show(this, "Loading",
                "Please waiting...", true);
        progress.show();

    }

    @Subscribe
    public void onClassClick(ClassStudent c) {// nhận click đang lỗi
        Log.e(TAG, "onClassClick: Vào bên nhận");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
