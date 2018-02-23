package com.tarena.chapter03.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ResultActivity extends Activity {
	EditText etName, etAge;
	String key;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		etName = (EditText) findViewById(R.id.etName);
		etAge = (EditText) findViewById(R.id.etAge);
		key = getIntent().getStringExtra("to");
	}

	public void doClick(View v) {

		Intent data = new Intent();
		String name = etName.getText().toString();
		String age = etAge.getText().toString();
		if (key.equals("getUserInfo")) {

			data.putExtra("name", name);
			data.putExtra("age", age);
			setResult(0, data);
//			setResult(resultCode, data)
		} 
		finish();
	}
}