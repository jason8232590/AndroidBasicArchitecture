package com.example.myapplication.slidemenuactivity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Scroller;

public class SlideMenuView extends RelativeLayout {

    private View mLeft;
    private View mContent;
    private int mLeftMeasureWidth;
    private float startX;
    private float downX;
    private float moveX;
    private float downY;
    private float moveY;
    private Scroller mScroller;
    boolean isLeftOpened = false;
    private int downX2;
    private int downY2;

    public SlideMenuView(Context context) {
        super(context);
    }

    public SlideMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public SlideMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Finalize inflating a view from XML. This is called as the last phase of inflation,
     * after all child views have been added.
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mLeft = getChildAt(0);
        mContent =  getChildAt(1);

        //获取left的宽度
        mLeftMeasureWidth = mLeft.getLayoutParams().width;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //slideMenu是一个viewgroup
        //所以要先写子view的measure

        //1.conent的宽高跟父容器（也就是slidemenu一样）
        mContent.measure(widthMeasureSpec, heightMeasureSpec);

        //2.mleft的宽是80dp,高和父容器一样
        //好像还有一种就是upspecified 也就是布局文件写多少就是多少？？？？？？
        int mLeftMeasureSpec = MeasureSpec.makeMeasureSpec(mLeftMeasureWidth, MeasureSpec.EXACTLY);
        mLeft.measure(mLeftMeasureSpec, heightMeasureSpec);

        //3.最后就到自己了
        int measuredWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measuredHeight = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(measuredWidth, measuredHeight);
        // 因为自己的大小没有变可以直接写下面的就行，但是这里暂时写上面的
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        super.onLayout(changed, l, t, r, b);
        //1.先放置mLeftView
//        mLeft.layout(-mLeft.getMeasuredWidth() + 100, 0, 100, mLeft.getMeasuredHeight());//这样可以露一点
//        mContent.layout(100, 0, mContent.getMeasuredWidth()+100, mContent.getMeasuredHeight());
        mLeft.layout(-mLeft.getMeasuredWidth(), 0, 0, mLeft.getMeasuredHeight());
        //2.在放置mContent
        mContent.layout(0, 0, mContent.getMeasuredWidth(), mContent.getMeasuredHeight());
    }

    /**
     * 避免滑动出现的几种极端情况
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("xcqw   onTouchEvent ACTION_DOWN");
                downX = event.getRawX();
                downY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = event.getRawX();
                moveY = event.getRawY();
                System.out.println("xcqw  ACTION_MOVE");
                float dx = downX - moveX;
                //The left edge of the displayed part of your view, in pixels
                //可以理解就是现在窗体的位置
                int verteX = getScrollX();
                System.out.println("xcqw  verteX" + verteX);
                System.out.println("xcqw  dx" + dx);
                //情况1 就是窗体最多移动-mLeft.getMeasuredWidth()
                if (verteX + dx < -mLeft.getMeasuredWidth()) {
                    //窗体直接移到-mLeft.getMeasuredWidth()！！！
                    //Set the scrolled position of your view
                    scrollTo(-mLeft.getMeasuredWidth(), 0);
                    System.out.println("xcqw 移到最左边");
                } else if (verteX + dx > 0) {
                    //情况2  就是窗体右移最多智能移到mContent.getMeasureWidth
                    System.out.println("xcqw 移到Content");
                    scrollTo(0, 0);
                } else {
                    //在原有位置上移动
                    System.out.println("xcqw  在当前位置移动");
                    scrollBy((int) dx, 0);
                }
                //更新坐标
                downX = moveX;
                downY = moveY;
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("xcqw  ACTION_UP");
                //根据移动到的位置来做自动开关
                //如果打开位置小于一半就关上 or  大于一半  就自动打开
                System.out.println("xcqw action_up 开还是关" + (getScrollX() < -mLeft.getMeasuredWidth() / 2));
                judgeOpenOrClose(getScrollX() < -mLeft.getMeasuredWidth() / 2);
                break;
        }
        return true;
        //深究一下为什么会是return false
//        return super.onTouchEvent(event);
    }

    private void judgeOpenOrClose(boolean open) {
        isLeftOpened = open;
        if (open) {
            //如果大于二分之一，就自动打开
            //The left edge of the displayed part of your view, in pixels.
            int startX = getScrollX();
            //The top edge of the displayed part of your view, in pixels.
            int startY = getScrollY();
            int endX = -mLeft.getMeasuredWidth();
            int endY = 0;

            int dx = endX - startX;
            int dy = endY - startY;
            //根据移动的px来设定滑动的速度（控制总共的时间），这样体验比较好
            int duration = Math.abs(dx) * 10;
            if (duration > 500) {
                duration = 500;
            }
            mScroller.startScroll(startX, startY, dx, dy, duration);

        } else {
            //如果小于二分之一，就自动关闭
            //The left edge of the displayed part of your view, in pixels.
            int startX = getScrollX();
            //The top edge of the displayed part of your view, in pixels.
            int startY = getScrollY();
            int endX = 0;
            int endY = 0;

            int dx = endX - startX;
            int dy = endY - startY;
            //根据移动的px来设定滑动的速度（控制总共的时间），这样体验比较好
            int duration = Math.abs(dx) * 10;
            if (duration > 500) {
                duration = 500;
            }
            mScroller.startScroll(startX, startY, dx, dy, duration);
        }
        //重新绘制 draw-->ondraw
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), 0);
            postInvalidate();
        }
    }

    public void openLeft() {
        //打开左边菜单
        judgeOpenOrClose(true);
    }

    public void closeLeft() {
        //关闭左边菜单
        judgeOpenOrClose(false);
    }

    //避免left的scroll吃掉左右滑动事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = getX();
                downY = getY();
                System.out.println("xcqw onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = getX();
                moveY = getY();
                float dx = downX - moveX;
                float dy = downY - moveY;
                if (Math.abs(dx) > Math.abs(dy)) {
                    //如果x方向移动大于y方向
                    //不分发了//自己处理
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }


    //为了解决当left全部脱出时点击content区域关闭left（也就是让他缩回去）
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX2 = (int) event.getX();
                //这里如果写downY会有问题  downY 跟 upY差太多//因为前面有个donwnY = moveY
                downY2 = (int) event.getY();

                System.out.println("xcqw dispatchTouchEvent  ACTION_DOWN");
                break;

            case MotionEvent.ACTION_MOVE:

                break;

            case MotionEvent.ACTION_UP:
                float upX = event.getX();
                float upY = event.getY();
                System.out.println("xcqw dispatchTouchEvent  ACTION_UP" + isLeftOpened);
                if (isLeftOpened) {
                    //因为像素点很小不可能每次按都是按同一个像素点，所以要给一个误差范围
                    System.out.println("xcqw dispatchTouchEvent  ACTION_UP  upX-" + upX + "-downX-" + downX);
                    System.out.println("xcqw dispatchTouchEvent  ACTION_UP  upY-" + upY + "-downY-" + downY);
                    System.out.println("xcqw dispatchTouchEvent  ACTION_UP  upX-" + upX + "-downX2-" + downX2);
                    System.out.println("xcqw dispatchTouchEvent  ACTION_UP  upY-" + upY + "-downY2-" + downY2);
                    if ((upX < downX2 + 4) && (upX > downX2 - 4) && upY < downY2 + 4 && upY > downY2 - 4) {
                        System.out.println("xcqw dispatchTouchEvent  ACTION_UP  x1");
                        //排除用户按住滑动然后放手
                        //点击位置跟弹起位置在一定范围内就认为是点了不是移动
                        //这样就可以排除了按着滑动一定距离的情况
                        //关闭left
                        if (upX > mLeft.getMeasuredWidth()) {
                            //这样是在left全部展开的情况点击关闭
                            //关闭左侧
                            System.out.println("xcqw dispatchTouchEvent  ACTION_UP  x2");
                            judgeOpenOrClose(false);
                            //自己就把他处理，不要别人来处理
                            return true;
                        }
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    public boolean isLeftOpen() {
        return isLeftOpened;
    }
}



