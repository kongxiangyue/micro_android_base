package com.tarena.chapter5.notificationdemo1;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		//创建一个通知的对象
		Notification noti = new Notification();
		Intent myIntent = new Intent(MainActivity.this,OtherActivity.class);
		PendingIntent myPendingIntent = PendingIntent.getActivity(MainActivity.this, 0, myIntent, 0);
		noti.setLatestEventInfo(MainActivity.this, "任务栏显示的标题", "任务栏显示的内容", myPendingIntent);
		noti.icon = R.drawable.ic_launcher;
		noti.tickerText = "通知的滚动显示内容。";
		noti.defaults = Notification.DEFAULT_SOUND;
		
		//设置声音 或者响铃的模式
		noti.audioStreamType = android.media.AudioManager.ADJUST_LOWER;
		//通知的发送时间
		noti.flags = Notification.FLAG_NO_CLEAR;
		noti.when = System.currentTimeMillis();
		
		manager.notify(R.drawable.ic_launcher, noti);
//		manager.cancel(id);
	}



}
