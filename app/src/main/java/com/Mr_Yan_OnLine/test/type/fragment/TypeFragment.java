package com.Mr_Yan_OnLine.test.type.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Mr_Yan_OnLine.test.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TypeFragment extends BaseFragment{

    private TextView mTextView;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mTextView = new TextView(mContext);
        return mTextView;
    }

    @Override
    public void initData() {
        mTextView.setText("分类页面的Fragment");
    }

}
