package com.Mr_Yan_OnLine.test.home.Vhoulder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.home.adapter.hot_adapter.Hot_Adapter;
import com.Mr_Yan_OnLine.test.home.bean.ResultBeanData;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/28
 * 备注
 */

public class Hot_Grid extends RecyclerView.ViewHolder {

    public final TextView mTv_more_hot;
    public final RecyclerView mRecyclerView_hot;
    Context context;
    ResultBeanData.ResultBean resultBean;

    public Hot_Grid(View itemView) {
        super(itemView);
        mTv_more_hot = (TextView) itemView.findViewById(R.id.tv_more_hot);
        mRecyclerView_hot = (RecyclerView) itemView.findViewById(R.id.recyclerView_hot);
        mRecyclerView_hot.setLayoutManager(new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL));
    }

    public void setData(final Context context, ResultBeanData.ResultBean resultBean) {
        this.context = context;
        this.resultBean = resultBean;
        /*设置查看更多的点击事件*/
        mTv_more_hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //成功后的吐丝
                Toast.makeText(context, "点击了:查看更多", Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView_hot.setAdapter(new Hot_Adapter(context,resultBean));

    }
}
