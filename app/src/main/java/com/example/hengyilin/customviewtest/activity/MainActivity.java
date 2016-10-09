package com.example.hengyilin.customviewtest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.hengyilin.customviewtest.R;
import com.example.hengyilin.customviewtest.adapter.MyListViewAdapter;
import com.example.hengyilin.customviewtest.view.MyListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyListView myListView;
    private MyListViewAdapter adapter;
    private List<String> strings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        initList();
        myListView = (MyListView) findViewById(R.id.my_list_view);
        adapter = new MyListViewAdapter(this, 0, strings);
        myListView.setDeleteClickListener(new MyListView.DeleteListener() {
            @Override
            public void delete(int index) {
                strings.remove(index);
                adapter.notifyDataSetChanged();
            }
        });
        myListView.setAdapter(adapter);
    }

    private void initList() {
        for (int i = 0; i < 20; i++) {
            strings.add("字符串" + i);
        }
    }
}
