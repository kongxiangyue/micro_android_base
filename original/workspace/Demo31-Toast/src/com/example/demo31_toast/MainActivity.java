package com.example.demo31_toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toast.makeText(MainActivity.this, "一个Toast提示", 0).show();
        Toast toast = new Toast(MainActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
         View view = inflater.inflate(R.layout.toast, null);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }


}
