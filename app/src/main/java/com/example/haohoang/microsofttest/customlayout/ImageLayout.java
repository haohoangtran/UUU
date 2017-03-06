package com.example.haohoang.microsofttest.customlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by tranh on 3/6/2017.
 */

public class ImageLayout extends RelativeLayout {

    public ImageLayout(Context context) {
        super(context);
    }

    public ImageLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width=MeasureSpec.getSize(widthMeasureSpec);
        double height=width*0.75;
        heightMeasureSpec=MeasureSpec.makeMeasureSpec((int)height,MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
