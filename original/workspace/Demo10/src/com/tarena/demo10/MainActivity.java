package com.tarena.demo10;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
//	public static final String MYACTION = "com.tarena.demo10.MY_ACTION";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.button1://��ʾIntent

			Intent intent1 = new Intent(MainActivity.this, Activity02.class);
			startActivity(intent1);
			break;

		case R.id.button2://��ʽIntent
			Intent intent2 = new Intent();
			intent2.setAction("MY_ACTION_TEST");
			startActivity(intent2);

			break;
		case R.id.button3://ʹ��Intent��绰
			Intent intent3 = new Intent();
			// ��ʾҪִ�еĶ������˴�Ϊ���Ŷ���
			intent3.setAction(Intent.ACTION_CALL);
			// ��ʾҪ����ĵ绰����
			Uri uri = Uri.parse("tel://10010");
			// ��������Ϊ��Intent������
			intent3.setData(uri);
			startActivity(intent3);
			break;
		case R.id.button4://ʹ��Intent������

			Intent intent4 = new Intent();
			// ��ʾҪִ�еĶ������˴�Ϊ�����Ŷ���
			intent4.setAction(Intent.ACTION_SENDTO);
			// ��ʾҪ���Ͷ��ŵĵ绰����
			Uri uri2 = Uri.parse("smsto://10010");
			// ��������Ϊ��Intent������
//			intent4.setDaeta(uri2);
			// �˴�Ϊ��Intent���һ��keyΪ��sms_body����ֵΪ��HelloWorld����һ������ ��ʾ��������
			intent4.putExtra("sms_body", "HelloWorld");
			startActivity(intent4);
			break;
		}
	}

}