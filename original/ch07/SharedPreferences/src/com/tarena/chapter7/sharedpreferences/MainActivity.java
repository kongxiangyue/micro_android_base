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
		// 生成一个默认名字的SharedPreferences文件
		// pref =
		// PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
		// 生成一个指定名字的SharedPreferences文件，同时指定其权限为可追加模式
		pref = getSharedPreferences("myPref", MODE_PRIVATE);
		write.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// 启用编辑
				Editor editor = pref.edit();
				editor.putBoolean("sound", true);
				editor.putString("userName", "张三");
				editor.putInt("score", 100);
				editor.putLong("date", System.currentTimeMillis());
				editor.putFloat("x", 1.5f);
				// 移除指定"key"的相关数据
				editor.remove("x");
				// 提交保存，此处如果不执行提交，editor的所有操作无效
				editor.commit();
				// 注意：editor在commit之后的操作数据无效，如果想让其生效需要再次commit。

			}
		});
		read.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				StringBuilder s = new StringBuilder();
				s.append("背景音乐：" + pref.getBoolean("sound", false)).append("\n");
				s.append("用户名：" + pref.getString("userName", null)).append("\n");
				s.append("分数：" + pref.getInt("score", 0)).append("\n");
				s.append("date："
						+ new Date(pref.getLong("date", 0)).toLocaleString()).append("\n");
				s.append("x：" + pref.getFloat("x", 0));
				result.setText(s);

			}
		});

	}

}
