package com.example.hengyilin.customviewtest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.example.hengyilin.customviewtest.R;

/**
 * Created by hengyilin on 16-10-9.
 */

public class MyAttrbuteView extends View {
    public MyAttrbuteView(Context context) {
        super(context, null);
    }

    public MyAttrbuteView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MyAttrbuteView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyAttrbuteView);
//        int length = typedArray.getIndexCount();
//        for (int i = 0; i < length; i++) {
//            String userName = typedArray.getString(i);
//            switch ()
//        }
        String userName = typedArray.getString(R.styleable.MyAttrbuteView_username);
        String password = typedArray.getString(R.styleable.MyAttrbuteView_password);
        int age = typedArray.getInt(R.styleable.MyAttrbuteView_age, 0);
        System.out.println("userName = " + userName + " password = " + password + " age = " + age);
        typedArray.recycle();

    }
}
