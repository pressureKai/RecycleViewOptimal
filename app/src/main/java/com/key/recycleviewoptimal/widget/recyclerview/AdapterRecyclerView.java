package com.key.recycleviewoptimal.widget.recyclerview;

import android.content.Context;
import androidx.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

/**
 * created by key  on 2019/2/20
 */
public abstract  class AdapterRecyclerView extends RecyclerView.Adapter<ItemRecyclerView> {
    protected Context mContext;
    protected boolean isEmpty;
    public AdapterRecyclerView(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public ItemRecyclerView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return createView(viewGroup,i);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRecyclerView itemRecyclerView, int i) {
         itemRecyclerView.getItemView().setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
         setData(itemRecyclerView.getItemView(),i);
    }

    @Override
    public int getItemViewType(int position) {
        if(isEmpty){
            return -1;
        }
        return super.getItemViewType(position);
    }

    public abstract void setData(View view, int position);
    public abstract ItemRecyclerView createView(ViewGroup parent,int viewType);
    @Override
    public abstract int getItemCount();
}
