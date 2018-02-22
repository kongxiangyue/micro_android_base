package com.tarena.chapter7.sharedpreferences;

import java.util.Date;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button write;
	Button read;
	TextView result;
	SharedPreferences pref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		write = (Button) findViewById(R.id.btWrite);
		read = (Button) findViewById(R.id.btRead);
		result = (TextView) findViewById(R.id.tvResult);
		// ����һ��Ĭ�����ֵ�SharedPreferences�ļ�
		// pref =
		// PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
		// ����һ��ָ�����ֵ�SharedPreferences�ļ���ͬʱָ����Ȩ��Ϊ��׷��ģʽ
		pref = getSharedPreferences("myPref", MODE_PRIVATE);
		write.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// ���ñ༭
				Editor editor = pref.edit();
				editor.putBoolean("sound", true);
				editor.putString("userName", "����");
				editor.putInt("score", 100);
				editor.putLong("date", System.currentTimeMillis());
				editor.putFloat("x", 1.5f);
				// �Ƴ�ָ��"key"���������
				editor.remove("x");
				// �ύ���棬�˴������ִ���ύ��editor�����в�����Ч
				editor.commit();
				// ע�⣺editor��commit֮��Ĳ���������Ч�������������Ч��Ҫ�ٴ�commit��

			}
		});
		read.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				StringBuilder s = new StringBuilder();
				s.append("�������֣�" + pref.getBoolean("sound", false)).append("\n");
				s.append("�û�����" + pref.getString("userName", null)).append("\n");
				s.append("������" + pref.getInt("score", 0)).append("\n");
				s.append("date��"
						+ new Date(pref.getLong("date", 0)).toLocaleString()).append("\n");
				s.append("x��" + pref.getFloat("x", 0));
				result.setText(s);

			}
		});

	}

}
