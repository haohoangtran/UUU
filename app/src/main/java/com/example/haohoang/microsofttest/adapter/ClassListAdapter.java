package com.example.haohoang.microsofttest.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haohoang.microsofttest.R;
import com.example.haohoang.microsofttest.activities.StudentListActivity;
import com.example.haohoang.microsofttest.adapter.viewhodler.ClassListViewHodler;
import com.example.haohoang.microsofttest.classlistdata.ClassStudent;
import com.example.haohoang.microsofttest.evenbus.GotoStudentListActivity;
import com.example.haohoang.microsofttest.networks.NetContext;
import com.example.haohoang.microsofttest.services.FaceGroupService;
import com.example.haohoang.microsofttest.sutudentdata.Student;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Vector;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tranh on 3/6/2017.
 */

public class ClassListAdapter extends RecyclerView.Adapter<ClassListViewHodler> {
    private final String TAG=ClassListAdapter.class.toString();
    private Context context;
    private final String urlGetList="https://westus.api.cognitive.microsoft.com/face/v1.0/persongroups?start=0";
    private List<ClassStudent> classStudentList=new Vector<>();
    @Override
    public ClassListViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.class_item, parent, false);

        //2: create ViewHolder
        return new ClassListViewHodler(itemView);
    }

    public ClassListAdapter(Context context) {
        this.context=context;
        getAllGroup();
    }

    private void getAllGroup() {
        FaceGroupService faceGroupService= NetContext.instance.create(FaceGroupService.class);
        faceGroupService.getAllGroup(urlGetList).enqueue(new Callback<List<ClassStudent>>() {
            @Override
            public void onResponse(Call<List<ClassStudent>> call, Response<List<ClassStudent>> response) {
                classStudentList =response.body();
                for (ClassStudent classStudent : classStudentList) {
                    Log.e(TAG, String.format("onResponse: %s", classStudent.toString()) );
                }
                notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ClassStudent>> call, Throwable t) {
                Log.e(TAG, String.format("onFailure: %s", t.toString()) );
            }
        });
    }

    @Override
    public void onBindViewHolder(ClassListViewHodler holder, int position) {
         final ClassStudent classStudent=classStudentList.get(position);
        classStudent.setStudents(new Vector<Student>());
        holder.bind(classStudent);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, StudentListActivity.class);
                context.startActivity(intent);
                EventBus.getDefault().post(classStudent);
                Log.e(TAG, "onClick: gửi" );
            }
        });
    }

    @Override
    public int getItemCount() {
        return classStudentList.size();
    }


}
