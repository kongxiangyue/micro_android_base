package com.example.demo08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {
	TextView result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activiti_other);
		result = (TextView) findViewById(R.id.result);
		//TODO
		Intent intent = getIntent();
//		String name = intent.getStringExtra("Name");
//		int age = intent.getIntExtra("Age", 0);
		
		Bundle bundle = intent.getExtras();
		String name = bundle.getString("Name");
		int age = bundle.getInt("Age");
		result.setText("–’√˚£∫"+name+"\n"+"ƒÍ¡‰£∫"+age);
	}
}
