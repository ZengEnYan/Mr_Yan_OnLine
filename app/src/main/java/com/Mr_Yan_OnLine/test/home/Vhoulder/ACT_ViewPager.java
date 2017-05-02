package com.Mr_Yan_OnLine.test.home.Vhoulder;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.home.bean.ResultBeanData;
import com.Mr_Yan_OnLine.test.ui_xiangqing.ActWebViewsActivity;
import com.Mr_Yan_OnLine.test.utils.Constants;
import com.bumptech.glide.Glide;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/27
 * 备注
 */

public class ACT_ViewPager extends RecyclerView.ViewHolder {

    public final ViewPager mACT_viewPager;
    Context context;
    ResultBeanData.ResultBean resultBean;

    public ACT_ViewPager(View itemView) {
        super(itemView);
        mACT_viewPager = (ViewPager) itemView.findViewById(R.id.act_ViewPager);
    }

    public void setData(Context context, ResultBeanData.ResultBean resultBean) {
        this.context = context;
        this.resultBean = resultBean;
        mACT_viewPager.setAdapter(new ACT_Adapter());
    }

    /*设置ViewPager的适配器*/
    public class ACT_Adapter extends PagerAdapter{

        /*返回总条数*/
        @Override
        public int getCount() {
            return resultBean.getAct_info().size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        /*释放内存,销毁已经不用的item*/
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            /*这里必须删除*/
//            super.destroyItem(container, position, object);
            container.removeView((View) object);

        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            //创建一个图片对象,设置他内部元素拉伸填充
            ImageView imageView = new ImageView(context);
            /*设置他内部元素拉伸填充*/
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            //把用Glide框架加载数据添加到ImageView
            Glide.with(context)
                    .load(Constants.BASE_URL_IMAGE+resultBean.getAct_info().get(position).getIcon_url())
                    .into(imageView);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*intent 传值  WebView页*/
                    Intent intent = new Intent(context, ActWebViewsActivity.class);
                    intent.putExtra("actImg",Constants.BASE_URL_IMAGE+resultBean.getAct_info().get(position).getUrl());
                    context.startActivity(intent);
                }
            });
            /*最后记得添加View*/
            container.addView(imageView);
            return imageView;
        }
    }

}
