package com.aaa.test.myapplication.recyclerview.base.normal;

import android.content.Context;
import android.databinding.ViewDataBinding;

import com.aaa.test.myapplication.BR;
import com.aaa.test.myapplication.R;

/**
 * Created by Administrator on 2018/10/8.
 */

public class MyNormalAdapter extends BaseNormalBindingAdapter {

    public MyNormalAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.item_user;
    }

    @Override
    protected void onBindItem(ViewDataBinding binding, Object item) {
        binding.setVariable(BR.model,item);
    }
}
