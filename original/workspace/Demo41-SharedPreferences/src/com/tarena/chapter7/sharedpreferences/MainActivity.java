package com.tarena.chapter7.sharedpreferences;

import java.util.Date;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button write;
	Button read;
	TextView result;
	SharedPreferences sdf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		write = (Button) findViewById(R.id.btWrite);
		read = (Button) findViewById(R.id.btRead);
		result = (TextView) findViewById(R.id.tvResult);
//		PreferenceManager.getDefaultSharedPreferences(context)
		sdf = getSharedPreferences("myPref", MODE_PRIVATE);
		write.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Editor editor = sdf.edit();
				editor.putBoolean("sound", true);
				editor.putString("userName", "张三");
				editor.putInt("score", 100);
				editor.putLong("date", System.currentTimeMillis());
				editor.putFloat("x", 2.0f);
				editor.remove("x");
				editor.commit();
			}
		});
		read.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				StringBuilder strb = new StringBuilder();
				strb.append("背景音乐："+sdf.getBoolean("sound", false)+"\n");
				strb.append("用户名："+sdf.getString("userName", null)+"\n");
				strb.append("成绩："+sdf.getInt("score", 0)+"\n");
				strb.append("时间："+sdf.getLong("date", 0)+"\n");
				result.setText(strb.toString());
			}
		});

	}

}
