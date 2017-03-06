package com.example.haohoang.microsofttest.adapter.viewhodler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.haohoang.microsofttest.R;
import com.example.haohoang.microsofttest.sutudentdata.Student;
import java.io.InputStream;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tranh on 3/6/2017.
 */

public class StudentListHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_name)
    TextView tvNameStudent;
    @BindView(R.id.tv_idStudent)
    TextView tvIdStudent;
    @BindView(R.id.iv_student_img)
    ImageView ivStudent;
    public StudentListHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void bind(Student student){
        DownloadImageTask downloadImageTask=new DownloadImageTask(ivStudent);
        tvIdStudent.setText(student.getIdStudent());
        tvNameStudent.setText(student.getName());
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
