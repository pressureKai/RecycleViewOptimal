package com.key.recycleviewoptimal.widget.recyclerview;

import androidx.annotation.NonNull;
import android.view.View;

/**
 * created by key  on 2019/2/12
 */
public class ItemRecyclerView extends  RecyclerView.ViewHolder {
    private View itemView;

    public View getItemView() {
        return itemView;
    }

    public ItemRecyclerView(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

}
