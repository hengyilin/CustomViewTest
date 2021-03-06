package com.example.hengyilin.customviewtest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.hengyilin.customviewtest.R;

/**
 * Created by hengyilin on 16-10-9.
 */

public class CounterView extends View implements View.OnClickListener {

    private Paint mPaint;
    private Rect mBounds;
    private int count;

    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CounterView);
        String name = typedArray.getString(R.styleable.CounterView_username1);
        String password = typedArray.getString(R.styleable.CounterView_password1);
        int age = typedArray.getInt(R.styleable.CounterView_age1, -1);
        System.out.println("name = " + name + " password = " + password + " age = " + age);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();
        setOnClickListener(this);
    }

    public CounterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(30);
        String text = String.valueOf(count);
        mPaint.getTextBounds(text,0,text.length(),mBounds);
        float textWidth = mBounds.width();
        float textHeight = mBounds.height();
        canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2 - textHeight / 2, mPaint);

    }

    @Override
    public void onClick(View v) {
        count++;
        invalidate();
    }
}
