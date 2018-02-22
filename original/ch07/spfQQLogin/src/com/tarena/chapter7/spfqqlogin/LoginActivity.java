package com.tarena.chapter7.spfqqlogin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	EditText qqNumber;
	EditText qqPwd;
	Button login;
	CheckBox savePwd;
	CheckBox autoLogin;
	SharedPreferences pref;
	Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		pref = getSharedPreferences("myPref", MODE_PRIVATE);
		editor = pref.edit();
		qqNumber = (EditText) findViewById(R.id.qqNumber);
		qqPwd = (EditText) findViewById(R.id.qqPwd);
		login = (Button) findViewById(R.id.btLogin);
		savePwd = (CheckBox) findViewById(R.id.savePwd);
		autoLogin = (CheckBox) findViewById(R.id.autoLogin);
		String defaultnumber = pref.getString("qqNumber", "");
		String defaultpwd = pref.getString("qqpwd", "");
		if ((!defaultnumber.equals("")) && (!defaultpwd.equals(""))) {
			qqNumber.setText(defaultnumber);
			qqPwd.setText(defaultpwd);
			savePwd.setChecked(true);
		} else if ((!defaultnumber.equals("")) && (defaultpwd.equals(""))) {
			qqNumber.setText(defaultnumber);
			savePwd.setChecked(false);
		}

		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 如果账户密码不为空
				if ((!qqNumber.getText().toString().trim().equals(""))
						&& (!qqPwd.getText().toString().trim().equals(""))) {
					if (savePwd.isChecked()) {

						String number = qqNumber.getText().toString().trim();
						String pwd = qqPwd.getText().toString().trim();
						editor.putString("qqNumber", number);
						editor.putString("qqpwd", pwd);
						editor.commit();
					} else {
						editor.remove("qqpwd");
						editor.commit();
					}
					Intent intent = new Intent(LoginActivity.this,
							MainActivity.class);
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(LoginActivity.this, "账号或者密码不为空",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}