package com.example.ex03viewimg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by Kong on 2018/5/29 0029.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Bundle bundle = getIntent().getExtras();
        ((ImageView)findViewById(R.id.imageView2))
                .setImageResource(bundle.getInt("img"));

    }
}
