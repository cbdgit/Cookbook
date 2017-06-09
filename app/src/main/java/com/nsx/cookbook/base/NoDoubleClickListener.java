package com.nsx.cookbook.base;

import android.view.View;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/5/10.
 * 避免点击多次 出现多次点击事件
 */

public abstract class NoDoubleClickListener implements View.OnClickListener{
    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    public void onNoDoubleClick(View view){}
}