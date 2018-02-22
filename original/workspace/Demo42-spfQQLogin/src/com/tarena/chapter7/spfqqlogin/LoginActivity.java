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
		//TODO
		String defultqqNumber = pref.getString("qqNumber", "");
		String defultqqPwd = pref.getString("qqPwd", "");
		if (!defultqqNumber.equals("")&&!defultqqPwd.equals("")) {
			qqNumber.setText(defultqqNumber);
			qqPwd.setText(defultqqPwd);
			savePwd.setChecked(true);
		}else if(!defultqqNumber.equals("")&&defultqqPwd.equals("")){
			qqNumber.setText(defultqqNumber);
			savePwd.setChecked(false);
		}
		
		
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			//TODO
				//如果账号密码不为空
				if ((!qqNumber.getText().toString().equals(""))&&(!qqPwd.getText().toString().equals(""))) {
					if (savePwd.isChecked()) {
						editor.putString("qqNumber", qqNumber.getText().toString());
						editor.putString("qqPwd", qqPwd.getText().toString());
						editor.commit();
					}else {
						editor.remove("qqPwd");
						editor.commit();
					}
					Intent intent = new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
					finish();
					
				}else {
					Toast.makeText(LoginActivity.this, "用户名或者密码不能为空", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}