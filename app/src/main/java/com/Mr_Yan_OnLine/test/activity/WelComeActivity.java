package com.Mr_Yan_OnLine.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.Mr_Yan_OnLine.test.R;

/**
 * 0. 实例化Handler
 * 1. 用handler做延时操作
 * 2. 在延时操作后进行跳转,而为了防止点击返回键重新进入这个界面要在跳转后finish()掉
 * 3. 如果在延时操作还没有进行完的情况下推出程序,要移除这个线程
 */
public class WelComeActivity extends AppCompatActivity {
    //实例化handler
    Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
            }
        };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //做延时操作
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //跳转到Activity的方法
                JumpMainActivity();
            }
        },2000);
    }
    //跳转的方法(Ctrl+alt+m自动生成方法)
    private void JumpMainActivity() {
        startActivity(new Intent(WelComeActivity.this,MainActivity.class));
        //防止返回这里,finish().
        finish();
    }

    /**
     *在延时操作还没有完成的情况下退出,因为线程还没有销毁,所以延时操作结束后还会重新进去程序,
     * 为了防止这样的错误,我在onDestroy()把handler线程给移除掉.
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(0);
    }
}
