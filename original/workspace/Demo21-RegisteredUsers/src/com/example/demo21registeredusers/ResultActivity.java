package com.example.demo21registeredusers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		tv = (TextView) findViewById(R.id.tvresult);
		Intent intent = getIntent();
		String regInfo = intent.getStringExtra("regInfo");
		tv.setText(regInfo);
	}

}
