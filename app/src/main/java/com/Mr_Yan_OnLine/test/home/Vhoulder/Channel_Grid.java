package com.Mr_Yan_OnLine.test.home.Vhoulder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.home.adapter.channel_adapter.ChannelAdapter;
import com.Mr_Yan_OnLine.test.home.bean.ResultBeanData;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/26
 * 备注
 */

public class Channel_Grid extends RecyclerView.ViewHolder {

    public final RecyclerView mChannel_rv;
    Context context;
    ResultBeanData.ResultBean resultBean;
    public Channel_Grid(View itemView) {
        super(itemView);
        /*找到布局中要加载的控件 RecyclerView*/
        mChannel_rv = (RecyclerView) itemView.findViewById(R.id.channel_rv);
        /*在构造方法中设置布局管理器*/
        mChannel_rv.setLayoutManager(new StaggeredGridLayoutManager(5,RecyclerView.VERTICAL));
    }

    public void setData(Context context, ResultBeanData.ResultBean resultBean) {
        this.context =  context;
        this.resultBean = resultBean;
        /*再次加载adapter*/
        mChannel_rv.setAdapter(new ChannelAdapter(context,resultBean));
    }
}
