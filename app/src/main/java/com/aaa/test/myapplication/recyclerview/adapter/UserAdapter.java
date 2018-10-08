package com.aaa.test.myapplication.recyclerview.adapter;

import android.content.Context;

import com.aaa.test.myapplication.R;
import com.aaa.test.myapplication.databinding.ItemUserBinding;
import com.aaa.test.myapplication.recyclerview.base.BaseBindingAdapter;
import com.aaa.test.myapplication.recyclerview.model.User;

/**
 * Created by zmy on 2017/7/26.
 */

public class UserAdapter extends BaseBindingAdapter<User, ItemUserBinding>
{
    public UserAdapter(Context context)
    {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType)
    {
        return R.layout.item_user;
    }

    @Override
    protected void onBindItem(ItemUserBinding binding, User user)
    {
        binding.setModel(user);
        binding.executePendingBindings();
    }
}
