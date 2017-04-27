package com.Mr_Yan_OnLine.test.home.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.base.BaseFragment;
import com.Mr_Yan_OnLine.test.home.adapter.HomeRVAdapter;
import com.Mr_Yan_OnLine.test.home.bean.ResultBeanData;
import com.Mr_Yan_OnLine.test.utils.Constants;
import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private TextView mTextView;
    private View mView;
    private RecyclerView mRvHome;
    private TextView mTv_search_home;
    private TextView mTv_message_home;
    private ImageButton mIb_top;
    private ResultBeanData.ResultBean mResultBean;
    private HomeRVAdapter mHomeRVAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

            }
        };

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = View.inflate(mContext, R.layout.fragment_home, null);
        mRvHome = (RecyclerView) mView.findViewById(R.id.recyclerView);
        mIb_top = (ImageButton) mView.findViewById(R.id.ib_top);
        mTv_search_home = (TextView) mView.findViewById(R.id.tv_search_home);
        mTv_message_home = (TextView) mView.findViewById(R.id.tv_message_home);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swipeRefreshLayout);

        //设置点击事件
        initListener();

        return mView;
    }

    /**
     * //给控件设置点击事件
     * 点击回到顶部.就是加载第一条Item
     */
    private void initListener() {
        //置顶监听事件
        mIb_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回到顶部   加载第一条Item
                mRvHome.scrollToPosition(0);
                //成功后的吐丝
                Toast.makeText(mContext, "回到了顶部", Toast.LENGTH_SHORT).show();
            }
        });

        mTv_search_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //成功后的吐丝
                Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();
            }
        });

        mTv_message_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //成功后的吐丝
                Toast.makeText(mContext, "进入消息中心", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initData() {
        //使用okhttp工具类get请求网络
        OKhttpGETData();
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED,Color.BLUE,Color.CYAN,Color.YELLOW);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    //使用okhttp工具类get请求网络
    private void OKhttpGETData() {
        //若要改变请求自己的网址,改变url即可
        String url = Constants.HOME_URL;
        OkHttpUtils
                .get()//设置请求网络的方式
                .url(url)//设置请求网址
                //如果请求网址不需要账号,密码,可以把参数删掉
///*                .addParams("username", "hyman")
//                .addParams("password", "123")*/
                .build()
                .execute(new StringCallback() {
                    @Override//请求网络失败回调
                    public void onError(Call call, Exception e, int i) {
                        Toast.makeText(mContext, "网络失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override//请求网络成功回调,使用fastJson进行json的解析
                    public void onResponse(String s, int i) {
                        //测试是否能请求网络成功,及线程是否允许在主线程
                        Toast.makeText(mContext, "网络成功", Toast.LENGTH_SHORT).show();
                        Log.d("DS", s);
                        //json解析数据
                        processprocessData(s);
                    }
                });
    }

    //json解析数据
    private void processprocessData(String jsonData) {
        //使用fastJson解析数据,把整理好的数据放入指定的容器中     参数: json的数据   ,容器类的字节码
        ResultBeanData resultBeanData = JSON.parseObject(jsonData, ResultBeanData.class);
        //得到容器中装数据的集合
        mResultBean = resultBeanData.getResult();
        //测试是否得解析json数据成功
        String name = mResultBean.getHot_info().get(0).getName();
        Log.d("DS", name);
        if(resultBeanData!=null) {
            //实例化recycler适配器
            mHomeRVAdapter = new HomeRVAdapter(mContext, mResultBean);
            //设置布局管理者,
            mRvHome.setLayoutManager(new LinearLayoutManager(mContext));
            mRvHome.setAdapter(mHomeRVAdapter);
        }else {
            //成功后的吐丝
            Toast.makeText(mContext, "没有数据,不能展示", Toast.LENGTH_SHORT).show();
        }
    }
    /*下拉刷新  刷新适配器*/
    @Override
    public void onRefresh() {
        handler.postDelayed(new  Runnable() {
            @Override
            public void run() {
              /*刷新适配器*/
                initData();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        },2000);
    }
}
