package com.key.recycleviewoptimal.widget.recyclerview;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.key.recycleviewoptimal.R;
import com.key.recycleviewoptimal.widget.recyclerview.base.BaseFrameView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;


/**
 * created by key  on 2019/2/15
 */
public class BaseList extends BaseFrameView {
    protected SmartRefreshLayout mSwipe;
    protected RecyclerView mRecyclerView;
    protected FrameLayout mError;
    protected FrameLayout mLoading;
    protected FrameLayout mTop;
    protected Adapter mAdapter;
    protected boolean openAnimation = true;

    /**
     *    自定义View三部曲
     * @param context
     */
    public BaseList(Context context) {
        super(context);
    }

    public BaseList(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void initBase() {
        super.initBase();
        mView = View.inflate(getContext(), R.layout.recycle_list_base, null);
        init();
    }

    protected void init() {
        mSwipe = mView.findViewById(R.id.base_list_body);
        mRecyclerView = mView.findViewById(R.id.base_list_recycler);
        mError = mView.findViewById(R.id.base_list_error);
        mLoading = mView.findViewById(R.id.base_list_loading);
        mTop =  mView.findViewById(R.id.base_list_top);
        mRecyclerView.initList();
    }
    public void initList(int numColumn){
        mRecyclerView.initList(numColumn);
    }

    public void initList(int numColumn,int orientation){
        mRecyclerView.initList(numColumn,orientation);
    }



    public void setAdapter(Adapter adapter) {
        mAdapter = adapter;
        mRecyclerView.setAdapter(mAdapter);
    }


    public RecyclerView getListView() {
        return mRecyclerView;
    }



    public void setDivider(int color, int size) {
        mRecyclerView.setDivider(color, size);
    }

    public void setDefaultDivider() {
        mRecyclerView.setDefaultDivider();
    }

    public void setDividerDecration(androidx.recyclerview.widget.RecyclerView.ItemDecoration itemDecoration) {
        mRecyclerView.setDividerDecoration(itemDecoration);
    }

    public void goToPosition(int position) {
        mRecyclerView.goToPosition(position);
    }


    public void setRefreshEnable(boolean enable) {
        mSwipe.setEnabled(enable);
    }

    public void setStackFromEnd(boolean stackFromEnd) {
        mRecyclerView.setStackFromEnd(stackFromEnd);
    }

    public void notifyDataSetChanged() {
        mAdapter.notifyDataSetChanged();
    }


    public void setRecyclerViewParams(Context context){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context) {
            @Override
            public androidx.recyclerview.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new androidx.recyclerview.widget.RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }



    /**
     *   设置RecyclerView动画
     */
    public void setAnimation(){
        if(openAnimation){
            SlideInDownAnimator animator = new SlideInDownAnimator(new OvershootInterpolator(1f));
            animator.setRemoveDuration(1000);
            animator.setAddDuration(1000);
            mRecyclerView.setItemAnimator(animator);
        }
    }

}
