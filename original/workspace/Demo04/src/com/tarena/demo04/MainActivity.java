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
        //启动Activity
//        startActivity(intent);
        //待返回值的启动
//        startActivityForResult(intent, requestCode);
       //2Service
        //启动服务
//        startService(service);
        //绑定服务
//        bindService(service, conn, flags);
       //3发送广播
        //发送无序广播
//        sendBroadcast(intent);
        //发送有序广播
//        sendOrderedBroadcast(intent, receiverPermission)
        //发送静态广播
//        sendStickyBroadcast(intent);
    }


    
}
