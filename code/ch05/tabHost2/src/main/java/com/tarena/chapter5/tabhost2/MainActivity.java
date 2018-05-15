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
		th.setup(); // ��ʼ��TabHost

		TabSpec spec1 = th.newTabSpec("Tag1");
		spec1.setIndicator(createTabIndicator(th, "ͨ����¼", R.drawable.imgselect));
		spec1.setContent(R.id.tab1content);
		th.addTab(spec1);

		TabSpec spec2 = th.newTabSpec("Tag2");
		spec2.setIndicator(createTabIndicator(th, "��ϵ��", R.drawable.imgselect));
		spec2.setContent(R.id.tab2content);
		th.addTab(spec2);

		TabSpec spec3 = th.newTabSpec("Tag3");
		spec3.setIndicator(createTabIndicator(th, "����", R.drawable.imgselect));
		spec3.setContent(R.id.tab3content);
		th.addTab(spec3);

		th.setCurrentTab(1); // ����Ĭ����ʾ��2����������
	}

	/**
	 * ����������һ��View���󣬸ö���ָ��������ǩ��λ��ƣ� ����ʹ��һ�������ļ�tab_indicator .xml���Զ��嵼����ǩ����ʽ��
	 * ���Է����κεĿؼ���ȥ �����������һ��ͼ���һ������ ����ʵ����Ŀ�У�����Ҫʹ��selector
	 * ������ѡ����������ɵ�����ǩѡ����δ��ѡ�еı����ı䣬 ������δʵ����һ���ܡ�
	 * 
	 * @param th
	 *            TabHost����
	 * @param tabTitle
	 *            ������ǩ�����ֱ���
	 * @param tabIconId
	 *            ������ǩ��ͼ���ID
	 * @return ������ǩ��View
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
