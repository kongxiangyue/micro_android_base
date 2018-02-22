package com.tarena.demo05;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		start = (Button) findViewById(R.id.start);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// �˴��ǰ�ť�¼���ִ�з�����
				// 1
				// Intent intent= new
				// Intent(MainActivity.this,OtherActivity.class);
				// startActivity(intent);
				// 2
				// Intent intent = new Intent();
				// ComponentName cn = new
				// ComponentName(MainActivity.this,OtherActivity.class);
				// intent.setComponent(cn);
				// startActivity(intent);
				// 3
				// Intent intent = new Intent();
				// intent.setClass(MainActivity.this,OtherActivity.class);
				// startActivity(intent);
				// 4
				// Intent intent = new Intent();
				// intent.setClassName(MainActivity.this,OtherActivity.class.getName());
				// startActivity(intent);
				Intent intent = new Intent(MainActivity.this,
						OtherActivity.class);
				startActivity(intent);
			}
		});
	}

}
