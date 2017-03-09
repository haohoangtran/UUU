package com.example.haohoang.microsofttest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haohoang.microsofttest.R;
import com.example.haohoang.microsofttest.activities.StudentListActivity;
import com.example.haohoang.microsofttest.adapter.viewhodler.ClassListViewHodler;
import com.example.haohoang.microsofttest.adapter.viewhodler.StudentListHolder;
import com.example.haohoang.microsofttest.classlistdata.ClassStudent;
import com.example.haohoang.microsofttest.databases.DbStudentContext;
import com.example.haohoang.microsofttest.sutudentdata.Student;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;
import java.util.Vector;


/**
 * Created by tranh on 3/6/2017.
 */

public class StudentListAdapter extends RecyclerView.Adapter<StudentListHolder> {
    private final String TAG = StudentListAdapter.class.toString();
    private Context context;

    public StudentListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public StudentListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.student_item, parent, false);
        //2: create ViewHolder
        return new StudentListHolder(itemView);
    }


    @Override
    public void onBindViewHolder(StudentListHolder holder, int position) {
        Student student = DbStudentContext.instance.getStudents().get(position);
        Log.e(TAG, String.format("onBindViewHolder: %s", student) );
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        return DbStudentContext.instance.getStudents().size();
    }
}
