package com.tarena.chapter5.tabhost2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost th = (TabHost) findViewById(R.id.tabHost);
		th.setup(); // 初始化TabHost

		TabSpec spec1 = th.newTabSpec("Tag1");
		spec1.setIndicator(createTabIndicator(th, "通话记录", R.drawable.imgselect));
		spec1.setContent(R.id.tab1content);
		th.addTab(spec1);

		TabSpec spec2 = th.newTabSpec("Tag2");
		spec2.setIndicator(createTabIndicator(th, "联系人", R.drawable.imgselect));
		spec2.setContent(R.id.tab2content);
		th.addTab(spec2);

		TabSpec spec3 = th.newTabSpec("Tag3");
		spec3.setIndicator(createTabIndicator(th, "短信", R.drawable.imgselect));
		spec3.setContent(R.id.tab3content);
		th.addTab(spec3);

		th.setCurrentTab(1); // 设置默认显示第2个导航界面
	}

	/**
	 * 创建并返回一个View对象，该对象指定导航标签如何绘制， 这里使用一个布局文件tab_indicator .xml来自定义导航标签的样式，
	 * 可以放置任何的控件进去 ，这里放置了一个图标和一段文字 。真实的项目中，还需要使用selector
	 * （背景选择器）来完成导航标签选中与未被选中的背景改变， 本案例未实现这一功能。
	 * 
	 * @param th
	 *            TabHost对象
	 * @param tabTitle
	 *            导航标签的文字标题
	 * @param tabIconId
	 *            导航标签的图标的ID
	 * @return 导航标签的View
	 */
	private View createTabIndicator(TabHost th, String tabTitle, int tabIconId) {
		View tabIndicator = LayoutInflater.from(this).inflate(
				R.layout.tab_indicator, null, false);
		TextView textView1 = (TextView) tabIndicator
				.findViewById(R.id.tabTitle);
		textView1.setText(tabTitle);
		ImageView imageView1 = (ImageView) tabIndicator
				.findViewById(R.id.tabIcon);
		imageView1.setBackgroundResource(tabIconId);
		return tabIndicator;
	}
}
