package com.humu.sugartest;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by Administrator on 2019/3/20.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Sugar
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //模拟器时退出应用会执行，真机不会
        SugarContext.terminate();
    }
}
