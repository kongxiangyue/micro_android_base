package com.example.demo07_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		test = (Button) findViewById(R.id.test);
		test.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction("TEST_ACTION");
				intent.setAction("TEST_ACTION2");
				intent.setAction("TEST_ACTION3");
				intent.addCategory("TEST_CATEGORY");
				startActivity(intent);
			}
		});
	}

}
