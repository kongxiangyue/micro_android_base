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
		// 设置tabhost的布局
		// 从tabactivity上面获取放置tab的tabhost
		TabHost tabHost = getTabHost();
		// from(this)从这个tabactivity获取LayoutInflater
		LayoutInflater.from(this).inflate(R.layout.activity_main,// 存放tab布局的layout
				tabHost.getTabContentView(),// 通过tabhost获得存放tab页签内容的子布局
				true);// 是否将LayoutInflater绑定到根布局上
		// 1
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("已接电话")
				.setContent(R.id.tab01));
		tabHost.addTab(tabHost
				.newTabSpec("tab2")
				.setIndicator("呼出电话",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.tab02));
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("未接电话")
				.setContent(R.id.tab03));
	}
}
