package com.key.recycleviewoptimal.widget.recyclerview.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.key.recycleviewoptimal.widget.recyclerview.AdapterRecyclerView;
import com.key.recycleviewoptimal.widget.recyclerview.ItemRecyclerView;

import java.util.List;


/**
 * Created by lwxkey on 16/8/19.
 */
public abstract class AdapterBaseList<T> extends AdapterRecyclerView {

    public List<T> mList;

    protected Context mContext;


    public void setLists(List<T> list) {
        this.mList = list;
    }

    public void setList(List<T> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public List<T> getList() {
        return mList;
    }

    public AdapterBaseList(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public abstract void setData(View view, int position);

    @Override
    public abstract ItemRecyclerView createView(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }
}
