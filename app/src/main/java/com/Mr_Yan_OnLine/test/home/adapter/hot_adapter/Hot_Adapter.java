package com.Mr_Yan_OnLine.test.home.adapter.hot_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.clicklistener.OnRecyclerViewItemClickListener;
import com.Mr_Yan_OnLine.test.home.Vhoulder.hot_item.Hot_Item;
import com.Mr_Yan_OnLine.test.home.bean.ResultBeanData;
import com.Mr_Yan_OnLine.test.utils.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/28
 * 备注
 */

public class Hot_Adapter extends RecyclerView.Adapter<Hot_Item> {
    Context context;
    ResultBeanData.ResultBean resultBean;
    OnRecyclerViewItemClickListener onItemClickListener;
    public Hot_Adapter(Context context, ResultBeanData.ResultBean resultBean) {
        this.context = context;
        this.resultBean = resultBean;
    }

    @Override
    public Hot_Item onCreateViewHolder(ViewGroup parent, int viewType) {
        View hotItem = LayoutInflater.from(context).inflate(R.layout.hot_item, parent, false);
        return new Hot_Item(hotItem);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener onItemClickListener){
            this.onItemClickListener = onItemClickListener;
}
    @Override
    public void onBindViewHolder(Hot_Item holder, final int position) {
        ImageLoader.getInstance().displayImage(Constants.BASE_URL_IMAGE+resultBean.getHot_info().get(position).getFigure(),holder.mIv_hot);
        holder.mTv_hotName.setText(resultBean.getHot_info().get(position).getName());
        holder.mTv_hotPrice.setText("￥:"+resultBean.getHot_info().get(position).getCover_price());

        holder.mHotll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //成功后的吐丝
                Toast.makeText(context, "点击了:"+resultBean.getHot_info().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultBean.getHot_info().size();
    }
}
