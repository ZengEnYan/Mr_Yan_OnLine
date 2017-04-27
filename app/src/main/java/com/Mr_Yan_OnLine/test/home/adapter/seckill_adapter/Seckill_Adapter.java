package com.Mr_Yan_OnLine.test.home.adapter.seckill_adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.clicklistener.OnRecyclerViewItemClickListener;
import com.Mr_Yan_OnLine.test.home.Vhoulder.seckill_item.Seckill_Item;
import com.Mr_Yan_OnLine.test.home.bean.ResultBeanData;
import com.Mr_Yan_OnLine.test.utils.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/27
 * 备注
 */

public class Seckill_Adapter extends RecyclerView.Adapter<Seckill_Item> {
    Context context;
    ResultBeanData.ResultBean resultBean;
    private final DisplayImageOptions mOptions;
    OnRecyclerViewItemClickListener onItemClickListener;

    public Seckill_Adapter(Context context, ResultBeanData.ResultBean resultBean) {
        this.context = context;
        this.resultBean = resultBean;
        // 请求的资源不存在时显示的图片
        // 加载出错时显示的图片
        // 比默认的速度快效率高
//        		.displayer(new RoundedBitmapDisplayer(500))// 给图片设置圆角 int值 表示圆角的半径大小 值越大 越圆
        mOptions = new DisplayImageOptions.Builder()
                        .cacheInMemory(true).cacheOnDisk(true)
                        .showImageOnLoading(R.mipmap.ic_launcher)
                        .showImageForEmptyUri(R.mipmap.ic_launcher)// 请求的资源不存在时显示的图片
                        .showImageOnFail(R.mipmap.ic_launcher)// 加载出错时显示的图片
                        .bitmapConfig(Bitmap.Config.RGB_565)// 比默认的速度快效率高
//        		.displayer(new RoundedBitmapDisplayer(500))// 给图片设置圆角 int值 表示圆角的半径大小 值越大 越圆
                        .build();
    }

    @Override
    public Seckill_Item onCreateViewHolder(ViewGroup parent, int viewType) {
        View item_seckill = LayoutInflater.from(context).inflate(R.layout.item_seckill, parent, false);
        return new Seckill_Item(item_seckill);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(Seckill_Item holder, final int position) {
        ImageLoader.getInstance().displayImage(Constants.BASE_URL_IMAGE+resultBean.getSeckill_info().getList().get(position).getFigure(),holder.mIv_figure,mOptions);
        holder.mTv_name.setText(resultBean.getSeckill_info().getList().get(position).getName());
        /*设置加粗*/
        TextPaint tp = holder.mTv_cover_privce.getPaint();
        tp.setFakeBoldText(true);
        holder.mTv_cover_privce.setText("￥:"+resultBean.getSeckill_info().getList().get(position).getCover_price());
        /*设置价格虚线*/
        holder.mTv_origin_privce.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
        holder.mTv_origin_privce.setText("￥:"+resultBean.getSeckill_info().getList().get(position).getOrigin_price());
        /*设置点击事件*/
        holder.mItem_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //成功后的吐丝
                Toast.makeText(context, "点击:"+resultBean.getSeckill_info().getList().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultBean.getSeckill_info().getList().size();
    }
}
