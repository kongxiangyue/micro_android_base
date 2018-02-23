package com.tarena.chapter03.intentdemo;

import com.example.com.tarena.chapter03.intentdemo.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.button1:

			// Intent intent1 = new Intent();
			// ComponentName cn= new ComponentName(this,OtherActivity.class);
			// intent1.setComponent(cn);
			// startActivity(intent1);

			Intent intent1 = new Intent(MainActivity.this, Activity02.class);
			startActivity(intent1);
			break;

		case R.id.button2:
			Intent intent2 = new Intent();
			intent2.setAction("MY_ACTION_TEST");
			startActivity(intent2);

			break;
		case R.id.button3:
			Intent intent3 = new Intent();
			// 表示要执行的动作，此处为拨号动作
			intent3.setAction(Intent.ACTION_CALL);
			// 表示要拨打的电话号码
			Uri uri = Uri.parse("tel://10010");
			// 将号码作为此Intent的数据
			intent3.setData(uri);
			startActivity(intent3);
			break;
		case R.id.button4:

			Intent intent4 = new Intent();
			// 表示要执行的动作，此处为发短信动作
			intent4.setAction(Intent.ACTION_SENDTO);
			// 表示要发送短信的电话号码
			Uri uri2 = Uri.parse("smsto://10010");
			// 将号码作为此Intent的数据
			intent4.setData(uri2);
			// 此处为该Intent添加一组key为“sms_body”，值为“HelloWorld”的一组数据 表示短信内容
			intent4.putExtra("sms_body", "HelloWorld");
			startActivity(intent4);
			break;
		}
	}

}