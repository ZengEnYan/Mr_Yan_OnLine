package com.Mr_Yan_OnLine.test.home.Vhoulder.recommend_item;

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

public class Recommend_Item extends RecyclerView.ViewHolder{

    public final ImageView mIv_recommend;
    public final TextView mTv_recommendname;
    public final TextView mTv_recommendprice;
    public final LinearLayout mRecommend_ll;

    public Recommend_Item(View itemView) {
        super(itemView);

        mIv_recommend = (ImageView) itemView.findViewById(R.id.iv_recommend);
        mTv_recommendname = (TextView) itemView.findViewById(R.id.tv_recommendname);
        mTv_recommendprice = (TextView) itemView.findViewById(R.id.tv_recommendprice);
        mRecommend_ll = (LinearLayout) itemView.findViewById(R.id.recommend_ll);

    }
}
