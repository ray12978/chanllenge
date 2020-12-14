package com.ray.challenge;

import android.app.Activity;
import android.app.Application;

public class MyApplication extends Application {

    private Activity mCurrentActivity = null;

    public void onCreate() {
        super.onCreate();

    }

    public Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    public void setCurrentActivity(Activity mCurrentActivity) {
        this.mCurrentActivity = mCurrentActivity;
    }
}