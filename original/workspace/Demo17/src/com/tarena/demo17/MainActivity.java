package com.tarena.demo17;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText shengao, tizhong;
	Button jisuan, quxiao;
	double height;
	double weight;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		shengao = (EditText) findViewById(R.id.shengao);
		tizhong = (EditText) findViewById(R.id.tizhong);
		jisuan = (Button) findViewById(R.id.jisuan);
		quxiao = (Button) findViewById(R.id.quxiao);
		jisuan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				try {
					if (shengao.getText()==null||"".equals(shengao.getText().toString()) ) {
						shengao.setError("身高不能为空");
						return;
					}
					if (tizhong.getText()==null||"".equals(tizhong.getText().toString()) ) {
						tizhong.setError("体重不能为空");
						return;
					}
					if (shengao.getText()!=null&&!"".equals(shengao.getText().toString())) {
						height = Double.parseDouble(shengao.getText().toString());
					}
					if (tizhong.getText()!=null&&!"".equals(tizhong.getText().toString())) {
						weight = Double.parseDouble(tizhong.getText().toString());
					}
					double bmi = weight/height/height;
					//TODO
				} catch (NumberFormatException e) {
					Toast.makeText(MainActivity.this, "身高或者体重必须为数字", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		quxiao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO
			}
		});
	}

}
