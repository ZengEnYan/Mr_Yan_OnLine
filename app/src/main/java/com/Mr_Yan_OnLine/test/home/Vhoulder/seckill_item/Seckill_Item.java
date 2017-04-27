package com.Mr_Yan_OnLine.test.home.Vhoulder.seckill_item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Mr_Yan_OnLine.test.R;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/27
 * 备注
 */

public class Seckill_Item extends RecyclerView.ViewHolder{

    public final ImageView mIv_figure;
    public final TextView mTv_cover_privce;
    public final TextView mTv_origin_privce;
    public final TextView mTv_name;
    public final LinearLayout mItem_ll;

    public Seckill_Item(View itemView) {
        super(itemView);
        mIv_figure = (ImageView) itemView.findViewById(R.id.iv_figure);
        mTv_cover_privce = (TextView) itemView.findViewById(R.id.tv_cover_price);
        mTv_origin_privce = (TextView) itemView.findViewById(R.id.tv_origin_price);
        mTv_name = (TextView) itemView.findViewById(R.id.tv_name);
        mItem_ll = (LinearLayout) itemView.findViewById(R.id.item_ll);
    }
}
