package com.Mr_Yan_OnLine.test.home.adapter.recommend_adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.clicklistener.OnRecyclerViewItemClickListener;
import com.Mr_Yan_OnLine.test.home.Vhoulder.recommend_item.Recommend_Item;
import com.Mr_Yan_OnLine.test.home.bean.ResultBeanData;
import com.Mr_Yan_OnLine.test.home.bean.SeckillBean;
import com.Mr_Yan_OnLine.test.ui_xiangqing.ShopXiangQingActivity;
import com.Mr_Yan_OnLine.test.utils.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.greenrobot.eventbus.EventBus;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/28
 * 备注
 */

public class Recommend_Adapter extends RecyclerView.Adapter<Recommend_Item> {
    Context context;
    ResultBeanData.ResultBean resultBean;
    OnRecyclerViewItemClickListener onItemClickListener;
    public Recommend_Adapter(Context context, ResultBeanData.ResultBean resultBean) {
        this.context = context;
        this.resultBean = resultBean;
    }

    @Override
    public Recommend_Item onCreateViewHolder(ViewGroup parent, int viewType) {
        View recommend_item = LayoutInflater.from(context).inflate(R.layout.recommend_item, parent, false);
        return new Recommend_Item(recommend_item);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(Recommend_Item holder, final int position) {
        ImageLoader.getInstance().displayImage(Constants.BASE_URL_IMAGE+resultBean.getRecommend_info().get(position).getFigure(),holder.mIv_recommend);
        holder.mTv_recommendname.setText(resultBean.getRecommend_info().get(position).getName());
        holder.mTv_recommendprice.setText("￥:"+resultBean.getRecommend_info().get(position).getCover_price());
        /*设置Item的点击事件   详情页*/
        holder.mRecommend_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*EventBus传值*/
                EventBus.getDefault().postSticky(new SeckillBean("￥:"+resultBean.getRecommend_info().get(position).getCover_price(),Constants.BASE_URL_IMAGE+resultBean.getRecommend_info().get(position).getFigure(),resultBean.getRecommend_info().get(position).getName()));
                context.startActivity(new Intent(context, ShopXiangQingActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultBean.getRecommend_info().size();
    }
}
