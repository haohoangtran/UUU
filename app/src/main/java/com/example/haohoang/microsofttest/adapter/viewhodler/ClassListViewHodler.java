package com.example.haohoang.microsofttest.adapter.viewhodler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.haohoang.microsofttest.R;
import com.example.haohoang.microsofttest.classlistdata.ClassStudent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tranh on 3/6/2017.
 */

public class ClassListViewHodler extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_classname)
    TextView tvClassName;
    @BindView(R.id.tv_classsize)
    TextView tvClassSize;
    @BindView(R.id.tv_classroom)
    TextView tvClassRoom;
    public ClassListViewHodler(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void bind(ClassStudent classStudent){
            tvClassName.setText(classStudent.getName());
            tvClassRoom.setText(classStudent.getClassRoom());
            tvClassSize.setText(classStudent.getStudents().size()+"");
    }
}
