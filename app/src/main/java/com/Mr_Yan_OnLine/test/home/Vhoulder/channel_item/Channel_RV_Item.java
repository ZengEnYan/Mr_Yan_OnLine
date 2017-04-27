package com.Mr_Yan_OnLine.test.home.Vhoulder.channel_item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Mr_Yan_OnLine.test.R;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/26
 * 备注:加载布局文件   找到控件ID
 */

public class Channel_RV_Item extends RecyclerView.ViewHolder {

    public final ImageView mIv_channel;
    public final TextView mTv_channel;
    public final LinearLayout mChannel_ll;

    public Channel_RV_Item(View itemView) {
        super(itemView);
        mChannel_ll = (LinearLayout) itemView.findViewById(R.id.channel_ll);
        mIv_channel = (ImageView) itemView.findViewById(R.id.iv_channel);
        mTv_channel = (TextView) itemView.findViewById(R.id.tv_channel);
    }
}
