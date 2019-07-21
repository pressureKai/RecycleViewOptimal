package com.key.recycleviewoptimal.widget.recyclerview.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * created by key  on 2019/2/15
 */
public class BaseFrameView extends RelativeLayout implements View.OnClickListener {
    protected View mView;
    protected Context mContext;
    public BaseFrameView(Context context) {
        super(context);
        mContext = context;
        initThis(context, null);
    }

    public BaseFrameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initThis(context,attrs);
    }

    public BaseFrameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initThis(context,attrs);
    }


    protected void initThis(Context context, AttributeSet attrs){
       initBase();
       attachView();
       if(attrs != null){
           dealAttrs(attrs);
       }
       init();
    }

    protected void attachView() {
        mView = getLayoutView();
        if(mView != null){
           addView(mView);
        }
    }

    /**
     *   交给子类实现，用于加载布局
     */
    protected void initBase() {

    }

    protected void dealAttrs(AttributeSet attrs) {

    }



    protected int getLayout(){
        return 0;
    }

    protected void init(){

    }

    @Override
    public void onClick(View v) {

    }


    protected View getLayoutView() {
        int layoutRes = getLayout();
        if (layoutRes != 0) {
            mView = LayoutInflater.from(mContext).inflate(layoutRes, this, false);
        }
        return mView;
    }

}
