package com.Mr_Yan_OnLine.test.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.Mr_Yan_OnLine.test.R;
import com.Mr_Yan_OnLine.test.base.BaseFragment;
import com.Mr_Yan_OnLine.test.community.fragment.CommunityFragment;
import com.Mr_Yan_OnLine.test.home.fragment.HomeFragment;
import com.Mr_Yan_OnLine.test.shopingcart.fragment.ShopingFragment;
import com.Mr_Yan_OnLine.test.type.fragment.TypeFragment;
import com.Mr_Yan_OnLine.test.user.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 1.完成XML布局
 * 2.搭建ButterKnife环境,安装studio插件(提示:ButterKnife7.0,如果用8.0,记着还要对工作空间的build文件进行配置)
 * 3.创建BaseFragment
 * 4.定义各个子页面的Fragment
 * 5.初始化Fragment,将其中放入容器中
 * 6.设置RadioGroup的监听
 * 7.得到对应的Fragment,进行切换
 * 8.对Fragment进行优化,解决切换Fragment,会再次创建Fragment,重走生命周期方法的问题,以及横竖屏切换Fragment内容重叠问题
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.frameLayout)
    FrameLayout mFrameLayout;
    @Bind(R.id.radioGroup)
    RadioGroup mRadioGroup;
    @Bind(R.id.rb_home)
    RadioButton mRbHome;
    @Bind(R.id.rb_type)
    RadioButton mRbType;
    @Bind(R.id.rb_community)
    RadioButton mRbCommunity;
    @Bind(R.id.rb_cart)
    RadioButton mRbCart;
    @Bind(R.id.rb_user)
    RadioButton mRbUser;
    private List<BaseFragment> mFragments;
    private FragmentTransaction mTransaction;
    private BaseFragment mBaseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //初始化Fragment
        initFragment();
        //默认显示rb_home
        mRadioGroup.check(R.id.rb_home);
        //默认显示的颜色
        mRbHome.setTextColor(Color.parseColor("#FF0000"));
        mRbType.setTextColor(Color.parseColor("#666666"));
        mRbCommunity.setTextColor(Color.parseColor("#666666"));
        mRbCart.setTextColor(Color.parseColor("#666666"));
        mRbUser.setTextColor(Color.parseColor("#666666"));
        //默认加载homeFragment
        RePlaceFragment(mFragments.get(0));
    }

    //初始化Fragment,并将Fragment装入list容器
    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new TypeFragment());
        mFragments.add(new CommunityFragment());
        mFragments.add(new ShopingFragment());
        mFragments.add(new UserFragment());
    }

    //选择fragment的对应编号(从零开始)
    private int position;


    @OnClick({R.id.rb_home, R.id.rb_type, R.id.rb_community, R.id.rb_cart, R.id.rb_user})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_home:
                position = 0;
                mRbHome.setTextColor(Color.parseColor("#FF0000"));
                mRbType.setTextColor(Color.parseColor("#666666"));
                mRbCommunity.setTextColor(Color.parseColor("#666666"));
                mRbCart.setTextColor(Color.parseColor("#666666"));
                mRbUser.setTextColor(Color.parseColor("#666666"));
                mRadioGroup.check(R.id.rb_home);
                break;
            case R.id.rb_type:
                position = 1;
                mRbHome.setTextColor(Color.parseColor("#666666"));
                mRbType.setTextColor(Color.parseColor("#FF0000"));
                mRbCommunity.setTextColor(Color.parseColor("#666666"));
                mRbCart.setTextColor(Color.parseColor("#666666"));
                mRbUser.setTextColor(Color.parseColor("#666666"));
                mRadioGroup.check(R.id.rb_type);
                break;
            case R.id.rb_community:
                position = 2;
                mRbHome.setTextColor(Color.parseColor("#666666"));
                mRbType.setTextColor(Color.parseColor("#666666"));
                mRbCommunity.setTextColor(Color.parseColor("#FF0000"));
                mRbCart.setTextColor(Color.parseColor("#666666"));
                mRbUser.setTextColor(Color.parseColor("#666666"));
                mRadioGroup.check(R.id.rb_community);
                break;
            case R.id.rb_cart:
                position = 3;
                mRbHome.setTextColor(Color.parseColor("#666666"));
                mRbType.setTextColor(Color.parseColor("#666666"));
                mRbCommunity.setTextColor(Color.parseColor("#666666"));
                mRbCart.setTextColor(Color.parseColor("#FF0000"));
                mRbUser.setTextColor(Color.parseColor("#666666"));
                mRadioGroup.check(R.id.rb_cart);
                break;
            case R.id.rb_user:
                position = 4;
                mRbHome.setTextColor(Color.parseColor("#666666"));
                mRbType.setTextColor(Color.parseColor("#666666"));
                mRbCommunity.setTextColor(Color.parseColor("#666666"));
                mRbCart.setTextColor(Color.parseColor("#666666"));
                mRbUser.setTextColor(Color.parseColor("#FF0000"));
                mRadioGroup.check(R.id.rb_user);
                break;
            default:
                position = 0;
                mRbHome.setTextColor(Color.parseColor("#FF0000"));
                mRbType.setTextColor(Color.parseColor("#666666"));
                mRbCommunity.setTextColor(Color.parseColor("#666666"));
                mRbCart.setTextColor(Color.parseColor("#666666"));
                mRbUser.setTextColor(Color.parseColor("#666666"));
                mRadioGroup.check(R.id.rb_home);
                break;
        }
        //得到相应的fragment
        BaseFragment baseFragment = mFragments.get(position);
        //替换Fragment
        RePlaceFragment(baseFragment);

    }

    private void RePlaceFragment(BaseFragment baseFragment) {
//        //获取fragment的管理器
//        FragmentManager supportFragmentManager = getSupportFragmentManager();
//        //通过管理器开启事务
//        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//        //通过事务对象把XML里的对象替换成Fragment
//        FragmentTransaction replace = fragmentTransaction.replace(R.id.frameLayout, baseFragment);
//        //最后提交
//        replace.commit();
        /**
         * 一行直接搞定 替换操作
         */
//        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, baseFragment).commit();

        /**
         * 显示隐藏,优化fragment  ,解决切换Fragment,会再次创建Fragment,
         * 重走生命周期方法的问题,以及横竖屏切换Fragment内容重叠问题
         */
        //得带fragment管理器
        mTransaction = getSupportFragmentManager().beginTransaction();
        //如果mBaseFragment不等于空就隐藏它
        if(mBaseFragment!=null){
            mTransaction.hide(mBaseFragment);
        }
        //如果当前的Fragment没有添加这个Activity容器里,就添加baseFragment到容器
        if(!baseFragment.isAdded()){
            mTransaction.add(R.id.frameLayout,baseFragment);
        }
        //最后显示
        mTransaction.show(baseFragment).commit();
        //给mBaseFragment赋值
        mBaseFragment=baseFragment;
    }

    /**
     * 点击两次返回键退出应用程序
     */
    private long mExitTime;
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                /**
                 * 带图片的吐丝提示
                 */
                Toast t2 = Toast.makeText(MainActivity.this, "再点击一次返回键退出程序", Toast.LENGTH_SHORT);
                t2.setGravity(Gravity.CENTER, 0, 0);
                LinearLayout ll = (LinearLayout) t2.getView();
                ImageView img = new ImageView(MainActivity.this);
                img.setImageResource(R.mipmap.hy);
                ll.addView(img, 0);
                t2.show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
