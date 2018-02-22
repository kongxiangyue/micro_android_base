package com.tarena.chapter5.tabhost3wechat;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainActivity extends TabActivity {
	public static TabHost mTabHost;

	public static TabHost getmTabHost() {
		return mTabHost;
	}

	private RadioGroup main_radio;
	private RadioButton tab_icon_weixin, tab_icon_address, tab_icon_find,
			tab_icon_myself;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTabHost = getTabHost();
		final TabWidget tabWidget = mTabHost.getTabWidget();
		tabWidget.setStripEnabled(false);// Բ�Ǳ��߲�����
		// ���n��tabѡ����������ǵ�tab����ָʾ����Ŀ������Ӧ����
		mTabHost.addTab(mTabHost.newTabSpec("TAG1").setIndicator("0")
				.setContent(new Intent(this, WeixinActivity.class)));
		mTabHost.addTab(mTabHost.newTabSpec("TAG2").setIndicator("1")
				.setContent(new Intent(this, AddressActivity.class)));
		mTabHost.addTab(mTabHost.newTabSpec("TAG3").setIndicator("2")
				.setContent(new Intent(this, FindActivity.class)));
		mTabHost.addTab(mTabHost.newTabSpec("TAG4").setIndicator("3")
				.setContent(new Intent(this, MyselfActivity.class)));
		// �Ӿ���,�õ�ѡ��ť���TabWidget
		main_radio = (RadioGroup) findViewById(R.id.main_radio);
		tab_icon_weixin = (RadioButton) findViewById(R.id.tab_icon_weixin);
		tab_icon_address = (RadioButton) findViewById(R.id.tab_icon_address);
		tab_icon_find = (RadioButton) findViewById(R.id.tab_icon_find);
		tab_icon_myself = (RadioButton) findViewById(R.id.tab_icon_myself);
		main_radio
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(RadioGroup group, int id) {
						if (id == tab_icon_weixin.getId()) {
							mTabHost.setCurrentTab(0);
						} else if (id == tab_icon_address.getId()) {
							mTabHost.setCurrentTab(1);
						} else if (id == tab_icon_find.getId()) {
							mTabHost.setCurrentTab(2);
						} else if (id == tab_icon_myself.getId()) {
							mTabHost.setCurrentTab(3);
						}
					}
				});

	}
}