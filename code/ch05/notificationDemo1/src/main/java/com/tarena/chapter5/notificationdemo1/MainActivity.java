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
		//����һ��֪ͨ�Ķ���
		Notification noti = new Notification();
		Intent myIntent = new Intent(MainActivity.this,OtherActivity.class);
		PendingIntent myPendingIntent = PendingIntent.getActivity(MainActivity.this, 0, myIntent, 0);
		noti.setLatestEventInfo(MainActivity.this, "��������ʾ�ı���", "��������ʾ������", myPendingIntent);
		noti.icon = R.drawable.ic_launcher;
		noti.tickerText = "֪ͨ�Ĺ�����ʾ���ݡ�";
		noti.defaults = Notification.DEFAULT_SOUND;
		
		//�������� ���������ģʽ
		noti.audioStreamType = android.media.AudioManager.ADJUST_LOWER;
		//֪ͨ�ķ���ʱ��
		noti.flags = Notification.FLAG_NO_CLEAR;
		noti.when = System.currentTimeMillis();
		
		manager.notify(R.drawable.ic_launcher, noti);
//		manager.cancel(id);
	}



}
