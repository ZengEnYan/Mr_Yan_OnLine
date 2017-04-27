package com.Mr_Yan_OnLine.test.home.adapter.channel_adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.clicklistener.OnRecyclerViewItemClickListener;
import com.Mr_Yan_OnLine.test.home.Vhoulder.channel_item.Channel_RV_Item;
import com.Mr_Yan_OnLine.test.home.bean.ResultBeanData;
import com.Mr_Yan_OnLine.test.utils.Constants;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/26
 * 备注
 */

public class ChannelAdapter extends RecyclerView.Adapter<Channel_RV_Item> {
    Context context;
    ResultBeanData.ResultBean resultBean;
    private final DisplayImageOptions mOptions;
    OnRecyclerViewItemClickListener onItemClickListener;

    public ChannelAdapter(Context context, ResultBeanData.ResultBean resultBean) {
        this.context = context;
        this.resultBean = resultBean;
        // 请求的资源不存在时显示的图片
        // 加载出错时显示的图片
        // 比默认的速度快效率高
        // 给图片设置圆角 int值 表示圆角的半径大小 值越大 越圆
        mOptions = new DisplayImageOptions.Builder()
                        .cacheInMemory(true).cacheOnDisk(true)
                        .showImageOnLoading(R.mipmap.ic_launcher)
                        .showImageForEmptyUri(R.mipmap.ic_launcher)// 请求的资源不存在时显示的图片
                        .showImageOnFail(R.mipmap.ic_launcher)// 加载出错时显示的图片
                        .bitmapConfig(Bitmap.Config.RGB_565)// 比默认的速度快效率高
        		.displayer(new RoundedBitmapDisplayer(500))// 给图片设置圆角 int值 表示圆角的半径大小 值越大 越圆
                        .build();
    }

    @Override
    public Channel_RV_Item onCreateViewHolder(ViewGroup parent, int viewType) {
        View channelRVItem = LayoutInflater.from(context).inflate(R.layout.channel_rv_item, parent, false);
        Channel_RV_Item channelRvItem = new Channel_RV_Item(channelRVItem);
        return channelRvItem;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    /*设置数据*/
    @Override
    public void onBindViewHolder(Channel_RV_Item holder, final int position) {
        ImageLoader.getInstance().displayImage(Constants.BASE_URL_IMAGE+resultBean.getChannel_info().get(position).getImage(),holder.mIv_channel,mOptions);
        holder.mTv_channel.setText(resultBean.getChannel_info().get(position).getChannel_name());
        holder.mChannel_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //成功后的吐丝
                Toast.makeText(context, "点击:"+resultBean.getChannel_info().get(position).getChannel_name(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*返回条目数*/
    @Override
    public int getItemCount() {
        return resultBean.getChannel_info().size();
    }
}
