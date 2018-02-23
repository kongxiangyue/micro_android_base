package com.tarena.chapter03.intentdemo2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText etUserName, etPassword;

	private void setupView() {
		etUserName = (EditText) findViewById(R.id.etUserName);
		etPassword = (EditText) findViewById(R.id.etPassword);
	}

	public void doClick(View v) {
		switch (v.getId()) {
		case R.id.btlogin:
			String userName = etUserName.getText().toString();
			String password = etPassword.getText().toString();
			User user = new User(userName, password);
			if (new UserBuiness().exists(user)) {
				// 启动主Activity
				Intent intent = new Intent(this, ResultActivity.class);
				intent.putExtra("user", user);
				startActivity(intent);
				// 关闭当前Activity
				finish();
				
//				
//				MediaPlayer mp = new MediaPlayer();
//				mp.release()
			} else {
				Toast.makeText(this, "用户名或密码错误,请重新输入", 3000).show();
				etPassword.setText("");
			}
			break;

		case R.id.btcancle:
			etUserName.setText("");
			etPassword.setText("");
			break;
		}
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();
	}
}