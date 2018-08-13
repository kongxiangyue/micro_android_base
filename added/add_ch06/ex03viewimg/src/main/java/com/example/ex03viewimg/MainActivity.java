package com.example.ex03viewimg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


// *步骤-.ListView相关的准备 添加listview,新建layout
// *步骤-.SecondActivity相关准备 layout,类,注册
// *步骤-.图片资源准备
// *步骤-.ItemAdapter完善
// *步骤-.跳转及信息传递
// *步骤-.setAdapter

public class MainActivity extends AppCompatActivity {

    int[] imgRes = { R.drawable.sample0
            , R.drawable.sample1
            , R.drawable.sample2
            , R.drawable.sample3
            , R.drawable.sample4
            , R.drawable.sample5
            , R.drawable.sample6
            , R.drawable.sample7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ItemAdapter(this, imgRes));
    }
}
