package com.Mr_Yan_OnLine.test.home.Vhoulder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Mr_Yan_OnLine.test.R;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/26
 * 备注
 */

public class Channel_RV_Item extends RecyclerView.ViewHolder {

    public final ImageView mIv_channel;
    public final TextView mTv_channel;

    public Channel_RV_Item(View itemView) {
        super(itemView);
        mIv_channel = (ImageView) itemView.findViewById(R.id.iv_channel);
        mTv_channel = (TextView) itemView.findViewById(R.id.tv_channel);
    }
}
