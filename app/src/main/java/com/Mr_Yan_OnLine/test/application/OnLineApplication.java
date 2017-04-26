package com.Mr_Yan_OnLine.test.application;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/25
 * 备注
 */

public class OnLineApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化okhttp工具类
        initOKhttp();
        File demo = new File(Environment.getDownloadCacheDirectory().getPath()+"demo");

        		ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
        		.memoryCacheExtraOptions(480, 480)
        		.threadPoolSize(2)//设置线程池的大小
        		.threadPriority(4)//设置线程的优先级

        		.memoryCacheSize(2*1024*1024)//设置内存缓存区的大小
        		.diskCacheSize(20*1024*1024)//设置磁盘缓存区的大小
        		.diskCache(new UnlimitedDiscCache(demo))//自定义磁盘路径
        		.build();


        		ImageLoader.getInstance().init(configuration);
    }

    private void initOKhttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                //设置连接超时
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                //设置读取超时
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();
        //进行okhttp工具类初始化的操作
        OkHttpUtils.initClient(okHttpClient);
    }

}
