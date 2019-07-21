package com.key.recycleviewoptimal.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.key.recycleviewoptimal.R;
import com.key.recycleviewoptimal.widget.recyclerview.ItemRecyclerView;
import com.key.recycleviewoptimal.widget.recyclerview.base.AdapterBaseList;

/**
 * created by key  on 2019/7/21
 */
public class TestAdapter extends AdapterBaseList {
    private Context context;
    public TestAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void setData(View view, int position) {
        TextView test = view.findViewById(R.id.test);
        test.setText("test :" + position);
    }

    @Override
    public ItemRecyclerView createView(ViewGroup parent, int viewType) {
        return new ItemRecyclerView(View.inflate(context, R.layout.item_test,null));
    }
}
