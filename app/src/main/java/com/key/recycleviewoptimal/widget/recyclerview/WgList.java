package com.key.recycleviewoptimal.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.key.recycleviewoptimal.widget.recyclerview.base.AdapterBaseList;
import com.key.recycleviewoptimal.widget.recyclerview.base.ConstantValues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;


/**
 * Created by shuaq on 2016/10/14.
 */
public class WgList<K> extends BaseList {

    private int mCurPage = 1;

    private int mPageSize = ConstantValues.PAGESIZE;

    private List<K> mList;

    private AdapterBaseList<K> mAdapterBase;

    private boolean isRunning = false;

    private boolean openAnimation  = true;
    public WgList(Context context) {
        super(context);
    }

    public WgList(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WgList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init() {
        super.init();
    }

    public void setAdapter(AdapterBaseList<K> adapter) {
        super.setAdapter(adapter);
        mAdapterBase = adapter;
        if (mAdapterBase.getList() == null) {
            mList = new ArrayList<>();
            mAdapterBase.setList(mList);
        } else {
            mList = mAdapterBase.getList();
        }
    }

    public void handleData(List<K> list) {
        if (list == null)
            list = Collections.emptyList();
        mList = list;
        mAdapterBase.setLists(mList);
        if (mList.size() == 0) {
        } else {
            notifyDataSetChanged();
        }

    }

    @Override
    public void removeAllViews() {
        super.removeAllViews();
        mRecyclerView.removeAllViews();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }


    public List<K> getList() {
        if (mList == null)
            return new ArrayList<>();
        return mList;
    }

    public void setOpenAnimation(boolean openAnimation) {
        this.openAnimation = openAnimation;
    }

    /**
     *   设置RecyclerView动画
     */
    public void setAnimation(){
        if(openAnimation){
            SlideInDownAnimator animator = new SlideInDownAnimator(new OvershootInterpolator(1f));
            animator.setRemoveDuration(500);
            animator.setAddDuration(500);
            mRecyclerView.setItemAnimator(animator);
        }
    }

}
