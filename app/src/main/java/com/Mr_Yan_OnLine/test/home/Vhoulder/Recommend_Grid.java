package com.Mr_Yan_OnLine.test.home.Vhoulder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.home.adapter.recommend_adapter.Recommend_Adapter;
import com.Mr_Yan_OnLine.test.home.bean.ResultBeanData;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/28
 * 备注
 */

public class Recommend_Grid extends RecyclerView.ViewHolder {

    private final TextView mTv_more_recommend;
    Context context;
    ResultBeanData.ResultBean resultBean;
    private final RecyclerView mRecimment_rv;

    public Recommend_Grid(View itemView) {
        super(itemView);
        mTv_more_recommend = (TextView) itemView.findViewById(R.id.tv_more_recommend);
        mRecimment_rv = (RecyclerView) itemView.findViewById(R.id.recomment_RV);
        //设置布局管理器
        mRecimment_rv.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));
    }

    public void setData(final Context context, ResultBeanData.ResultBean resultBean) {
        this.context = context;
        this.resultBean = resultBean;
        mTv_more_recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //成功后的吐丝
                Toast.makeText(context, "点击了,查看更多", Toast.LENGTH_SHORT).show();
            }
        });
        mRecimment_rv.setAdapter(new Recommend_Adapter(context,resultBean));
    }
}
