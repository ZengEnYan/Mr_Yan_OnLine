package com.Mr_Yan_OnLine.test.home.Vhoulder.hot_item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Mr_Yan_OnLine.test.R;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/28
 * 备注
 */

public class Hot_Item extends RecyclerView.ViewHolder {

    public final ImageView mIv_hot;
    public final TextView mTv_hotName;
    public final TextView mTv_hotPrice;
    public final LinearLayout mHotll;

    public Hot_Item(View itemView) {
        super(itemView);
        mIv_hot = (ImageView) itemView.findViewById(R.id.iv_hot);
        mTv_hotName = (TextView) itemView.findViewById(R.id.tv_hotname);
        mTv_hotPrice = (TextView) itemView.findViewById(R.id.tv_hotprice);
        mHotll = (LinearLayout) itemView.findViewById(R.id.hotll);
    }
}
