package com.example.lenovo.ch03;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Lenovo on 2017/9/15.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Bundle bundle = getIntent().getExtras();

        String key1 = bundle.getString("key1");
        int    key2 = bundle.getInt("key2");

        TextView tx3 = (TextView) findViewById(R.id.textView3);

        tx3.setText("key1 的信息是："
                + key1
                + "   key2 的信息是："
                + key2);

    }


}
