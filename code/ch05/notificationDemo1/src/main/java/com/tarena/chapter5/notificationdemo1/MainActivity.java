package com.tarena.chapter5.notificationdemo1;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	NotificationManager manager;
	Notification noti;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		manager
				= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		//创建一个通知的对象
		noti = new Notification();
		Intent myIntent = new Intent(MainActivity.this, OtherActivity.class);
		myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		PendingIntent myPendingIntent
				= PendingIntent.getActivity(MainActivity.this, 0, myIntent, 0);

		noti.setLatestEventInfo(MainActivity.this
				, "任务栏显示的标题"
				, "任务栏显示的内容"
				, myPendingIntent);
		noti.icon = R.drawable.ic_launcher;
		noti.tickerText = "通知的滚动显示内容。";
		noti.defaults = Notification.DEFAULT_SOUND;
		
		//设置声音 或者响铃的模式
		noti.audioStreamType = android.media.AudioManager.ADJUST_LOWER;
		//通知的发送时间
		noti.flags = Notification.FLAG_NO_CLEAR;
		noti.when = System.currentTimeMillis();
		

		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				manager.notify(R.drawable.ic_launcher, noti);
			}
		});


//		manager.cancel(id);
	}



}
