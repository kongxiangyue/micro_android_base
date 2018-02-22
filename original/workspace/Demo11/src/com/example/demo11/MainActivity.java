package com.example.demo11;

import android.app.Activity;
import android.content.Intent;
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

	public void doClick(View v){
		switch (v.getId()) {
		case R.id.btlogin:
			String name = etUserName.getText().toString();
			String password = etPassword.getText().toString();
			
			User user = new User(name,password);
			UserBuiness ub = new UserBuiness();
			if (ub.exists(user)) {
				Intent intent = new Intent(MainActivity.this,ResultActivity.class);
				intent.putExtra("user", user);
				startActivity(intent);
				finish();//关闭当前的Activity
			}else {
				Toast.makeText(MainActivity.this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
				etPassword.setText("");
			}
			break;

		case R.id.btcancle:
			
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
