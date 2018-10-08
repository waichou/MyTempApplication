package com.aaa.test.myapplication.recyclerview.base.normal;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.aaa.test.myapplication.recyclerview.base.BaseBindingViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zmy on 2017/7/26.
 */

public abstract class BaseNormalBindingAdapter<M, B extends ViewDataBinding> extends RecyclerView.Adapter {
    protected Context context;
    protected List<M> items;

    public BaseNormalBindingAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    public List<M> getItems() {
        return items;
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        B binding = DataBindingUtil.inflate(LayoutInflater.from(this.context), this.getLayoutResId(viewType), parent, false);
        return new BaseBindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        B binding = DataBindingUtil.getBinding(holder.itemView);
        this.onBindItem(binding, this.items.get(position));
    }

    protected void resetItems(ObservableArrayList<M> newItems) {
        this.items = newItems;
    }
    //endregion

    protected abstract @LayoutRes
    int getLayoutResId(int viewType);

    protected abstract void onBindItem(B binding, M item);

}
