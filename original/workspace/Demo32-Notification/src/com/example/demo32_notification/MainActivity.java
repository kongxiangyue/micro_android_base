package com.example.demo32_notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button send; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);	
			Notification noti = new Notification();
			Intent intent = new Intent(MainActivity.this,OtherActivity.class);
			PendingIntent pdintent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
			noti.setLatestEventInfo(MainActivity.this, "标题", "内容", pdintent);
			noti.icon = R.drawable.ic_launcher;
			noti.tickerText="滚动显示的内容";
			noti.defaults = Notification.DEFAULT_SOUND;
			noti.flags  =Notification.FLAG_NO_CLEAR;
			noti.when = System.currentTimeMillis();
			manager.notify(R.drawable.ic_launcher, noti);
//			manager.cancel(R.drawable.ic_launcher);
			}
		});
    }



    
}
