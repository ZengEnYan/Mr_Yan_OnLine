package com.Mr_Yan_OnLine.test.ui_xiangqing;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
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
                SeckillBean seckillBean = (SeckillBean) msg.obj;
                /*设置加粗*/
                TextPaint tp = xq_Price.getPaint();
                tp.setFakeBoldText(true);
                xq_Price.setText(seckillBean.getCover_price());
//                /*设置价格虚线*/
//                xq_PriceNo.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
//                xq_PriceNo.setText(seckillBean.getOrigin_price());
                shopjs.setText(seckillBean.getName());
                ImageLoader.getInstance().displayImage(seckillBean.getFigure(),goodsImg);

            }
        };

    private SeckillBean mSeckillBean;
    private WebView mBaidu;

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*返回键*/
            case R.id.back_normal:
                finish();
                break;
            /*更多*/
            case R.id.pop_more:
                Toast.makeText(ShopXiangQingActivity.this, "更多", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(ShopXiangQingActivity.this, "加入购物车", Toast.LENGTH_SHORT).show();
                break;
            /*立即购买*/
            case R.id.buyShop:
                Toast.makeText(ShopXiangQingActivity.this, "立即购买", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    //,这个是主线程你就用这个就行了
     @Subscribe (sticky = true, threadMode = ThreadMode.BACKGROUND)
     public void getMessage(SeckillBean msgg){
         Log.e("Message===========>"," " + msgg.getName()+msgg.getFigure()+msgg.getCover_price());
         Message msg = Message.obtain();
         msg.obj = msgg;
        handler.sendMessage(msg);
     }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*onDestroy() 中  反注册*/
        EventBus.getDefault().unregister(this);
    }
}
