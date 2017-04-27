package com.Mr_Yan_OnLine.test.home.Vhoulder;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.home.adapter.seckill_adapter.Seckill_Adapter;
import com.Mr_Yan_OnLine.test.home.bean.ResultBeanData;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/27
 * 备注
 */

public class SeckillViewHoulder extends RecyclerView.ViewHolder {
    Context context;
    ResultBeanData.ResultBean resultBean;
    public final TextView mTv_time_seclill;
    public final TextView mTv_more_seclill;
    public final RecyclerView mRv_seckill;
    //E2.倒计时的时间,从服务器那拿两个值,进行相减得到倒计时的真实数值.这里定义了个临时变量
    private long dt=0;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            dt=dt-1000;
            //E2.把拿到的秒值时间数据转换为小时,分,秒的形式
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            String time = simpleDateFormat.format(new Date(dt));
            //E2.把倒计时显示到UI上
            mTv_time_seclill.setText(time);
            //E2.在不断发送消息前先移除一下,减少OOM
            handler.removeMessages(0);
            handler.sendEmptyMessageDelayed(0,1000);
            //E2.经过我们的仔细观察可以看到,时间为0时,依然再减,所以要进行判断
            if(dt <=0 ){
                //把所有消息移除
                handler.removeCallbacksAndMessages(null);
            }
        }

    };

    public SeckillViewHoulder(View itemView) {
        super(itemView);
        mTv_time_seclill = (TextView) itemView.findViewById(R.id.tv_time_seckill);
        mTv_more_seclill = (TextView) itemView.findViewById(R.id.tv_more_seckill);
        mRv_seckill = (RecyclerView) itemView.findViewById(R.id.rv_seckill);
        mRv_seckill.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
    }

    public void setData(Context context, ResultBeanData.ResultBean resultBean) {
        this.context = context;
        this.resultBean = resultBean;
        //E2.计算秒杀倒计时,应为从bean集合里,拿到的时间数据不是int型,所以用Integer进行转换(其逻辑代码就是java基础的内容)
        dt=Integer.valueOf(resultBean.getSeckill_info().getEnd_time()) -Integer.valueOf(resultBean.getSeckill_info().getStart_time());
        //E2.建立handler实现定时器的效果,循环发送消息,以便能够使时间不断减一
        handler.sendEmptyMessageDelayed(0,1000);
        mRv_seckill.setAdapter(new Seckill_Adapter(context,resultBean));
    }
}
