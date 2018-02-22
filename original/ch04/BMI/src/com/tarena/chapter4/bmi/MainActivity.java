package com.tarena.chapter4.bmi;

import com.tarena.chapter6.bmi.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText shengao, tizhong;
	Button jisuan, quxiao;
	double height = 0;
	double weight = 0;

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
					if (shengao.getText() == null
							|| "".equals(shengao.getText().toString().trim())) {
						shengao.setError("��߲���Ϊ��");
						return;
					}
					if (tizhong.getText() == null
							|| "".equals(tizhong.getText().toString().trim())) {
						tizhong.setError("���ز���Ϊ��");
						return;
					}

					if (shengao.getText() != null
							&& !"".equals(shengao.getText().toString().trim())) {
						height = Double.parseDouble(shengao.getText()
								.toString());
					}
					if (tizhong.getText() != null
							&& !"".equals(tizhong.getText().toString().trim())) {
						weight = Double.parseDouble(tizhong.getText()
								.toString());
					}
					double bmi = weight * 10000 / height / height;
					if (bmi < 18) {
						Toast.makeText(MainActivity.this, "�������ƫ��,���ǿӪ��", 3000)
								.show();
					} else if (bmi <= 25) {
						Toast.makeText(MainActivity.this, "������ı�׼,���������", 3000)
								.show();
					} else {
						Toast.makeText(MainActivity.this, "�������ƫ��,���ǿ����", 3000)
								.show();
					}
				} catch (NumberFormatException e) {
					Toast.makeText(MainActivity.this, "��߻����ر���������", 3000)
							.show();
					e.printStackTrace();
				}
			}
		});
		quxiao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				shengao.setText("");
				tizhong.setText("");
			}
		});

	}

}
