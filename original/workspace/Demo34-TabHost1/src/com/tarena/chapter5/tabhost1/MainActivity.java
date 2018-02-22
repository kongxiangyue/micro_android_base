package com.tarena.chapter5.tabhost1;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
	/** Called when the activity is first created. */ 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ����tabhost�Ĳ���
		// ��tabactivity�����ȡ����tab��tabhost
		TabHost tabHost = getTabHost();
		// from(this)�����tabactivity��ȡLayoutInflater
		LayoutInflater.from(this).inflate(R.layout.activity_main,// ���tab���ֵ�layout
				tabHost.getTabContentView(),// ͨ��tabhost��ô��tabҳǩ���ݵ��Ӳ���
				true);// �Ƿ�LayoutInflater�󶨵���������
		// 1
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("�ѽӵ绰")
				.setContent(R.id.tab01));
		tabHost.addTab(tabHost
				.newTabSpec("tab2")
				.setIndicator("�����绰",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.tab02));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("δ�ӵ绰")
				.setContent(R.id.tab03));
	}
}
