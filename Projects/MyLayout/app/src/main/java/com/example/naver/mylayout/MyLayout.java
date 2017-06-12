package com.example.naver.mylayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kepler on 2017-05-04.
 * Custom Layout with custom attributes weightSum and weight    "Vertical Mode Only"
 * Reference about attributes weightSum and weight [https://developer.android.com/reference/android/widget/LinearLayout.html - android:weightSum]
 * If you want to apply weight to your child view correctly, Note that you should set your 'android:layout_width' attribute to 0.
 */

public class MyLayout extends ViewGroup {
    private float mWeightSum;

    public MyLayout(Context context) {
        super(context);
        mWeightSum = -1.0f;
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyLayout, 0, 0);
        this.mWeightSum = typedArray.getFloat(R.styleable.MyLayout_weightSum, -1.0f);
        typedArray.recycle();
    }

    public void setWeightSum(float weightSum) {
        this.mWeightSum = weightSum;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (mWeightSum < 0) {
            mWeightSum = calculateWeightSum();
        }
        int remain = getRemainingSpaceAfterMeasureChildWithoutWeight(widthMeasureSpec, heightMeasureSpec);
        measureChildWithWeight(remain, widthMeasureSpec, heightMeasureSpec);
    }

    private int getRemainingSpaceAfterMeasureChildWithoutWeight(int widthMeasureSpec, int heightMeasureSpec) { // return remaining space
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int remain = widthSize;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            MyLayout.LayoutParams lp = (MyLayout.LayoutParams) child.getLayoutParams();
            if (lp.mWeight < 0) {
                final int childWidthSize = (lp.width > remain) ? remain : lp.width;
                final int childHeightMode = (lp.height == LayoutParams.MATCH_PARENT) ? MeasureSpec.EXACTLY : MeasureSpec.AT_MOST;

                final int myWidthSpec = MeasureSpec.makeMeasureSpec(childWidthSize, widthMode);
                final int myHeightSpec = MeasureSpec.makeMeasureSpec(heightSize, childHeightMode);

                child.measure(myWidthSpec, myHeightSpec);
                remain -= childWidthSize;
            }
        }
        return remain;
    }

    private void measureChildWithWeight(int space, int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            MyLayout.LayoutParams lp = (MyLayout.LayoutParams) child.getLayoutParams();
            if (lp.mWeight > 0) {
                final float ratio = lp.mWeight / mWeightSum;

                final int childWidthSize = (int) (space * ratio);
                final int childHeightMode = (lp.height == LayoutParams.MATCH_PARENT) ? MeasureSpec.EXACTLY : MeasureSpec.AT_MOST;

                final int myWidthSpec = MeasureSpec.makeMeasureSpec(childWidthSize, widthMode);
                final int myHeightSpec = MeasureSpec.makeMeasureSpec(heightSize, childHeightMode);

                child.measure(myWidthSpec, myHeightSpec);
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int startX = l;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int width = child.getMeasuredWidth();
            int height = child.getMeasuredHeight();

            child.layout(startX, 0, startX + width, height);
            startX += width;
        }
    }

    private float calculateWeightSum() {
        float sum = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            MyLayout.LayoutParams lp = (MyLayout.LayoutParams) child.getLayoutParams();
            if (lp.mWeight > 0)
                sum += lp.mWeight;
        }
        return sum;
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    static public class LayoutParams extends ViewGroup.LayoutParams {
        private float mWeight;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray typedArray = c.obtainStyledAttributes(attrs, R.styleable.MyLayout, 0, 0);
            this.mWeight = typedArray.getFloat(R.styleable.MyLayout_weight, -1.0f);
            typedArray.recycle();
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.mWeight = -1.0f;
        }

        public void setWeight(float weight) {
            this.mWeight = weight;
        }

    }
}