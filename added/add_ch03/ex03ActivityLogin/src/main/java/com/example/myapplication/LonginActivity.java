package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Kong on 2018/5/12 0012.
 */

public class LonginActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        TextView textView = (TextView) findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();

        String username = bundle.getString("username");
        String password = bundle.getString("password");

        textView.setText(username + "," + password);


    }
}

// 主界面完善 (输入框,按键)
// 新建Activity(第二界面),textview控件
// activity类,xml,注册
// 主界面的按键响应(拿输入框信息,放到intent的额外信息那里去,跳转)
// 第二界面,将intent的额外信息拿出来并显示





