package com.example.hengyilin.customviewtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.hengyilin.customviewtest.R;

/**
 * Created by hengyilin on 16-10-9.
 */

public class MyListView extends ListView implements View.OnTouchListener, GestureDetector.OnGestureListener {

    private GestureDetector detector; // 手势监听器
    private View btnDelete; // view对象
    private ViewGroup itemLayout;
    private int selectedItem;
    private boolean isDeleteShow;
    private DeleteListener listener;

    public interface DeleteListener {
        void delete(int index);
    }

    /**
     * 构造方法
     *
     * @param context
     * @param attrs
     */
    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        detector = new GestureDetector(getContext(), this); // 新建手势检测对象并设置本类为监听类
        setOnTouchListener(this); // 自己监听自己的触摸事件
    }

    public void setDeleteClickListener(DeleteListener listener) {
        this.listener = listener;
    }

    /*
        以下几个方法是手势监听的回调方法
         */

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean onDown(MotionEvent e) {
        if (!isDeleteShow) {
            selectedItem = pointToPosition((int) e.getX(), (int) e.getY());
        }
        return false;
    }
    /**
     *
     * @param e
     */
    @Override
    public void onShowPress(MotionEvent e) {

    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    /**
     *
     * @param e1
     * @param e2
     * @param distanceX
     * @param distanceY
     * @return
     */
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    /**
     *
     * @param e
     */
    @Override
    public void onLongPress(MotionEvent e) {

    }

    /**
     *
     * @param e1
     * @param e2
     * @param velocityX
     * @param velocityY
     * @return
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (!isDeleteShow && Math.abs(velocityX) > Math.abs(velocityY)) {
            btnDelete = LayoutInflater.from(getContext()).inflate(R.layout.view_title, null);
            btnDelete.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemLayout.removeView(btnDelete);
                    btnDelete = null;
                    isDeleteShow = false;
                    listener.delete(selectedItem); // 回调接口里的方法
                }
            });
            itemLayout = (ViewGroup) getChildAt(selectedItem - getFirstVisiblePosition());
            RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            param.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            param.addRule(RelativeLayout.CENTER_IN_PARENT);
            itemLayout.addView(btnDelete, param);
            isDeleteShow = true;
        }
        return false;
    }

    /**
     * 触摸事件监听的方法
     * @param v
     * @param event
     * @return
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isDeleteShow) {
            // 触摸事件回调函数自己处理触摸事件
            itemLayout.removeView(btnDelete);
            btnDelete = null;
            isDeleteShow = false;
            return false;
        } else {
            return detector.onTouchEvent(event); // 把触摸事件传递到手势监听器中处理
        }
    }
}
