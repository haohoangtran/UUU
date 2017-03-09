package com.example.haohoang.microsofttest.adapter.viewhodler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.haohoang.microsofttest.R;
import com.example.haohoang.microsofttest.sutudentdata.Student;
import com.example.haohoang.microsofttest.utils.Util;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.haohoang.microsofttest.R.id.imageView;

/**
 * Created by tranh on 3/6/2017.
 */

public class StudentListHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_nameStudent)
    TextView tvNameStudent;
    @BindView(R.id.tv_idStudent)
    TextView tvIdStudent;
    @BindView(R.id.iv_student_img)
    ImageView ivStudent;

    public StudentListHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Student student) {
        DownloadImageTask downloadImageTask = new DownloadImageTask(ivStudent);
        downloadImageTask.execute(student.getUrl());
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
