package com.Mr_Yan_OnLine.test.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.home.Vhoulder.ACT_ViewPager;
import com.Mr_Yan_OnLine.test.home.Vhoulder.BannerViewHoulder;
import com.Mr_Yan_OnLine.test.home.Vhoulder.Channel_Grid;
import com.Mr_Yan_OnLine.test.home.Vhoulder.Hot_Grid;
import com.Mr_Yan_OnLine.test.home.Vhoulder.Recommend_Grid;
import com.Mr_Yan_OnLine.test.home.Vhoulder.SeckillViewHoulder;
import com.Mr_Yan_OnLine.test.home.bean.ResultBeanData;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/26
 * 备注  就是HomeFragment下的RecyclerView适配器,在这里实现主页面丰富多彩的效果
 * 1.搭建加载不同类型的Item的RecyclerView适配器框架
 * 2.实现第一个item,广告条效果
 */

public class HomeRVAdapter extends RecyclerView.Adapter {
    /*上下文*/
    Context context;
    /*拿到传过来的集合  就是RecyclerView加载的Bean类数据*/
    ResultBeanData.ResultBean resultBean;
    /*加载布局的填充器对象*/
//    private final LayoutInflater mLayoutInflater;

    //A.广告条幅类型(int数从0开始,数组从0开始,程序界:万物从0开始)
    private static final int BANNER = 0;
    //A.频道类型
    private static final int CHANNEL = 1;
    //A.活动类型
    private static final int ACT = 2;
    //A.秒杀类型
    private static final int SECKILL = 3;
    //A.推荐类型
    private static final int RECOMMEND = 4;
    //A.热卖类型
    private static final int HOT = 5;
    //A.当前类型
    private int currentType = BANNER;

    public HomeRVAdapter(Context context, ResultBeanData.ResultBean resultBean) {
        this.context = context;
        this.resultBean = resultBean;
//        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        ;
        switch (currentType) {
            case 0:
                /*无限轮播*/
                View banner_ViewPager = LayoutInflater.from(context).inflate(R.layout.banner_viewpager, parent, false);
                viewHolder = new BannerViewHoulder(banner_ViewPager);
                break;
            case 1:
                /*频道类型*/
                View channel_RV = LayoutInflater.from(context).inflate(R.layout.channel_grid, parent, false);
                viewHolder = new Channel_Grid(channel_RV);
                break;
            case 2:
                View act_viewPager = LayoutInflater.from(context).inflate(R.layout.act_viewpager, parent, false);
                viewHolder = new ACT_ViewPager(act_viewPager);
                break;
            case 3:
                View seckill = LayoutInflater.from(context).inflate(R.layout.seckill, parent, false);
                viewHolder = new SeckillViewHoulder(seckill);
                break;
            case 4:
                View recommend_grid = LayoutInflater.from(context).inflate(R.layout.recommend_grid, parent, false);
                viewHolder = new Recommend_Grid(recommend_grid);
                break;
            case 5:
                View hot_Grid = LayoutInflater.from(context).inflate(R.layout.hot_grid, parent, false);
                viewHolder = new Hot_Grid(hot_Grid);
                break;
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        /*切记给currentType赋值*/
        switch (position) {
            /*Banner无限轮播*/
            case BANNER:
                currentType = BANNER;
                break;
            /*频道类型*/
            case CHANNEL:
                currentType = CHANNEL;
                break;
            /*活动类型*/
            case ACT:
                currentType = ACT;
                break;
            /*秒杀类型*/
            case SECKILL:
                currentType = SECKILL;
                break;
            /*推荐类型*/
            case RECOMMEND:
                currentType = RECOMMEND;
                break;
            /*热销类型*/
            case HOT:
                currentType = HOT;
                break;
        }

        return currentType;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (position) {
            /*banner无限轮播*/
            case 0:
                BannerViewHoulder bannerViewHoulder = (BannerViewHoulder) holder;
                bannerViewHoulder.setData(context, resultBean);
                break;
            /*频道类型*/
            case 1:
                Channel_Grid channelGrid = (Channel_Grid) holder;
                channelGrid.setData(context, resultBean);
                break;
            /*活动类型*/
            case 2:
                ACT_ViewPager act_ViewPager = (ACT_ViewPager) holder;
                act_ViewPager.setData(context, resultBean);
                break;
            /*秒杀类型*/
            case 3:
                SeckillViewHoulder seckillViewHoulder = (SeckillViewHoulder) holder;
                seckillViewHoulder.setData(context, resultBean);
                break;
            /*推荐类型*/
            case 4:
                Recommend_Grid recommend_Grid = (Recommend_Grid) holder;
                recommend_Grid.setData(context,resultBean);
                break;
            case 5:
                Hot_Grid hotGrid = (Hot_Grid) holder;
                hotGrid.setData(context,resultBean);
                break;
        }
    }

    /*返回的条目数*/
    @Override
    public int getItemCount() {
        return 6;
    }
}
