package com.example.ex03viewimg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
