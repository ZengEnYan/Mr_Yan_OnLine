package com.Mr_Yan_OnLine.test.ui_xiangqing;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.text.TextPaint;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.home.bean.SeckillBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ShopXiangQingActivity extends Activity implements View.OnClickListener {

    private ImageView back_normal;
    private ImageView pop_more;
    private ImageView goodsImg;
    private TextView shopjs;
    private TextView xq_Price;
    private TextView xq_PriceNo;
    private TextView tv_good_info_desc;
    private ImageView kefu_Img;
    private TextView kefu;
    private ImageView sscc_img;
    private TextView sscc;
    private Button addShopCar;
    private Button buyShop;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mSeckillBean = (SeckillBean) msg.obj;
                /*设置加粗*/
            TextPaint tp = xq_Price.getPaint();
            tp.setFakeBoldText(true);
            xq_Price.setText(mSeckillBean.getCover_price());
//                /*设置价格虚线*/
//                xq_PriceNo.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
//                xq_PriceNo.setText(seckillBean.getOrigin_price());
            shopjs.setText(mSeckillBean.getName());
            ImageLoader.getInstance().displayImage(mSeckillBean.getFigure(), goodsImg);

        }
    };

    private WebView mBaidu;
    private LinearLayout mMore_layout;
    private Button mBtn_more;
    private TextView mTv_more_share;
    private TextView mTv_more_search;
    private TextView mTv_more_home;
    private SeckillBean mSeckillBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        /*注册EventBus*/
        EventBus.getDefault().register(this);
        initView();
        initData();
    }

    private void initData() {

        WebSettings settings = mBaidu.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        mBaidu.setWebViewClient(new WebViewClient());
        mBaidu.loadUrl("http://www.baidu.com");

    }

    private void initView() {
        back_normal = (ImageView) findViewById(R.id.back_normal);
        pop_more = (ImageView) findViewById(R.id.pop_more);
        goodsImg = (ImageView) findViewById(R.id.goodsImg);
        shopjs = (TextView) findViewById(R.id.shopjs);
        xq_Price = (TextView) findViewById(R.id.xq_Price);
        xq_PriceNo = (TextView) findViewById(R.id.xq_PriceNo);
        tv_good_info_desc = (TextView) findViewById(R.id.tv_good_info_desc);
        kefu_Img = (ImageView) findViewById(R.id.kefu_Img);
        kefu = (TextView) findViewById(R.id.kefu);
        sscc_img = (ImageView) findViewById(R.id.sscc_img);
        sscc = (TextView) findViewById(R.id.sscc);
        addShopCar = (Button) findViewById(R.id.addShopCar);
        buyShop = (Button) findViewById(R.id.buyShop);
        mBaidu = (WebView) findViewById(R.id.baidu);
        /*更多里的 分享  搜索  首页*/
        mTv_more_share = (TextView) findViewById(R.id.tv_more_share);
        mTv_more_search = (TextView) findViewById(R.id.tv_more_search);
        mTv_more_home = (TextView) findViewById(R.id.tv_more_home);
        /*点击... 更多*/
        mMore_layout = (LinearLayout) findViewById(R.id.more_layout);
        /*隐藏更多*/
        mBtn_more = (Button) findViewById(R.id.btn_more);

        addShopCar.setOnClickListener(this);
        buyShop.setOnClickListener(this);
        /*返回键*/
        back_normal.setOnClickListener(this);
        /*... 更多*/
        pop_more.setOnClickListener(this);
        /*客服*/
        kefu_Img.setOnClickListener(this);
        kefu.setOnClickListener(this);
        /*收藏*/
        sscc_img.setOnClickListener(this);
        sscc.setOnClickListener(this);
        /*隐藏更多*/
        mBtn_more.setOnClickListener(this);
        /*更多里的 分享  搜索  首页*/
        mTv_more_share.setOnClickListener(this);
        mTv_more_search.setOnClickListener(this);
        mTv_more_home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*返回键*/
            case R.id.back_normal:
                finish();
                break;
            /*显示更多*/
            case R.id.pop_more:
                mMore_layout.setVisibility(View.VISIBLE);
                break;
            /*隐藏更多*/
            case R.id.btn_more:
                mMore_layout.setVisibility(View.GONE);
                break;
            /*更多里的 分享  搜索  首页*/

            case R.id.tv_more_share:
                //成功后的吐丝
                Toast.makeText(ShopXiangQingActivity.this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_more_search:
                //成功后的吐丝
                Toast.makeText(ShopXiangQingActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_more_home:
                Toast.makeText(ShopXiangQingActivity.this, "首页", Toast.LENGTH_SHORT).show();

                break;
            /*客服*/
            case R.id.kefu_Img:
                //成功后的吐丝
                Toast.makeText(ShopXiangQingActivity.this, "客服", Toast.LENGTH_SHORT).show();
                break;
            case R.id.kefu:
                Toast.makeText(ShopXiangQingActivity.this, "客服", Toast.LENGTH_SHORT).show();
                break;
            /*收藏*/
            case R.id.sscc_img:
                Toast.makeText(ShopXiangQingActivity.this, "收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sscc:
                Toast.makeText(ShopXiangQingActivity.this, "收藏", Toast.LENGTH_SHORT).show();
                break;
            /*添加到购物车*/
            case R.id.addShopCar:
                /**
                 * 首先第一个参数,contentView提供一个展示的内容视图
                 * 第二个参数是宽
                 * 第三个是高
                 * 这里我们做的是指定 popuwindow的视图
                 */
                View contentView = View.inflate(ShopXiangQingActivity.this, R.layout.shop_pop_item, null);
                final PopupWindow popupWindow = new PopupWindow(contentView, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                /*popuWindow的属性,设置成true代表在popuwindow外部可以点击且popwindow会消失*/
                popupWindow.setOutsideTouchable(true);
                /*设置在某控件上边*/
                int[] location = new int[2];
                v.getLocationOnScreen(location);
                popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], location[1] - popupWindow.getHeight());
                /*查找控件ID*/
                ImageView goodsImage = (ImageView) contentView.findViewById(R.id.goodsImage);
                TextView goodsPrice = (TextView) contentView.findViewById(R.id.goodsPrice);
                TextView goodsShow = (TextView) contentView.findViewById(R.id.goodsShow);
                Button addCar = (Button) contentView.findViewById(R.id.addCar);

                ImageLoader.getInstance().displayImage(mSeckillBean.getFigure(), goodsImage);
                goodsPrice.setText(mSeckillBean.getCover_price());
                goodsShow.setText(mSeckillBean.getName());

                addCar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                break;
            /*立即购买*/
            case R.id.buyShop:
                Toast.makeText(ShopXiangQingActivity.this, "立即购买", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //,这个是主线程你就用这个就行了
    @Subscribe(sticky = true, threadMode = ThreadMode.BACKGROUND)
    public void getMessage(SeckillBean msgg) {
        Log.e("Message===========>", " " + msgg.getName() + msgg.getFigure() + msgg.getCover_price());
        Message msg = Message.obtain();
        msg.obj = msgg;
        handler.sendMessage(msg);
    }

    /*onDestroy() 中  反注册*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*onDestroy() 中  反注册*/
        EventBus.getDefault().unregister(this);
    }
}
