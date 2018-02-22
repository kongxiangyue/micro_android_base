package com.tarena.chapter5.notificationdemo2;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends Activity {

	Button start;
	NotificationManager manager;// 通知管理者
	Notification notis;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		start = (Button) findViewById(R.id.download);

		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				notis = new Notification();
				Intent intents = new Intent();
				PendingIntent pdintents = PendingIntent.getActivity(
						MainActivity.this, 0, intents, 0);
				notis.flags = Notification.FLAG_NO_CLEAR;
				notis.tickerText = "下载提示";
				notis.contentIntent = pdintents;
				notis.icon = R.drawable.ic_launcher;
				notis.when = System.currentTimeMillis();
				notis.contentView = new RemoteViews(getPackageName(), R.layout.noti);
				notis.contentView.setTextViewText(R.id.tvMusicName, "忐忑");
				notis.contentView.setTextViewText(R.id.tvProgress, "0kb");
				notis.contentView.setTextViewText(R.id.tvTotalLength, "100kb");
				notis.contentView.setProgressBar(R.id.pbDownload, 100, 0, false);
				manager.notify(123, notis);
				new Thread(){ 

					@Override
					public void run() {
					for (int i = 0; i < 100; i+=10) {
						try {
							sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						notis.contentView.setProgressBar(R.id.pbDownload, 100, i, false);
						notis.contentView.setTextViewText(R.id.tvProgress, i+"kb");
						manager.notify(123, notis);
					}
					manager.cancel(123);
					}
					
				}.start();
			}
		});
	}

}
