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
        //注意的是：executePendingBindings这句话需要加上，作用就是马上执行bind的数据绑定关系，即立刻执行上面binding.setModel这句话！
        //如果不加，则后续的binding.nameId.setText("hello android!");都会被binding.setModel(user);覆盖掉
        binding.executePendingBindings();
        //注意的是：如果需要修改掉与databinding相同的view元素，则需要在executePendingBindings后面执行，否则无效！
        binding.nameId.setText("hello android!");


        //小结：需在binding code 后 执行binding.executePendingBindings();使其立即生效，数据填充！ 后续如有View状态还是数据更新可以在执行方法后面再去执行！
    }
}
