package com.tarena.chapter03.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void doClick(View v) {
		Intent intent = new Intent(MainActivity.this, ResultActivity.class);
		switch (v.getId()) {
		case R.id.start1:
			intent.putExtra("to", "getUserInfo");
			startActivity(intent);
			break;

		case R.id.start2:
			intent.putExtra("to", "getUserInfo");
			startActivityForResult(intent, 0);
			// startActivityForResult(intent, requestCode);
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		String name = data.getStringExtra("name") + "";
		String age = data.getStringExtra("age") + "";
		Toast.makeText(MainActivity.this,
				"返回结果是：" + "\n" + "用户名：" + name + "\n" + "年    龄：" + age, 2222)
				.show();
	}
}
