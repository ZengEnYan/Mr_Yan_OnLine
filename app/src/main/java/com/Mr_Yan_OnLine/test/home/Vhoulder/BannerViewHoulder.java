package com.Mr_Yan_OnLine.test.home.Vhoulder;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.carousel.GlideImageLoader;
import com.Mr_Yan_OnLine.test.home.bean.ResultBeanData;
import com.Mr_Yan_OnLine.test.utils.Constants;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/26
 * 备注
 */

public class BannerViewHoulder extends RecyclerView.ViewHolder {

    public final Banner mBanner;
    private List<String> imageList = new ArrayList<>();

    public BannerViewHoulder(View itemView) {
        super(itemView);
        mBanner = (Banner) itemView.findViewById(R.id.banners);
    }

    public void setData(Context context, ResultBeanData.ResultBean resultBean) {
        for (int i = 0; i < resultBean.getBanner_info().size(); i++) {
            imageList.add(Constants.BASE_URL_IMAGE+resultBean.getBanner_info().get(i).getImage());
        }

        //无限轮播
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.ScaleInOut);
        mBanner.setImages(imageList).setImageLoader(new GlideImageLoader()).start();
    }
}
