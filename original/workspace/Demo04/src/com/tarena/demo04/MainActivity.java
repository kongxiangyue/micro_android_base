package com.tarena.demo04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //1Activity 
//        Intent intent = new Intent(MainActivity.this,Other.class);
        //����Activity
//        startActivity(intent);
        //������ֵ������
//        startActivityForResult(intent, requestCode);
       //2Service
        //��������
//        startService(service);
        //�󶨷���
//        bindService(service, conn, flags);
       //3���͹㲥
        //��������㲥
//        sendBroadcast(intent);
        //��������㲥
//        sendOrderedBroadcast(intent, receiverPermission)
        //���;�̬�㲥
//        sendStickyBroadcast(intent);
    }


    
}
