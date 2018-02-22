package com.tarena.chapter8.locationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tx2 = (TextView)findViewById(R.id.textView1);
		tx2.setText(R.string.text_a);
		TextView tx3 = (TextView)findViewById(R.id.textView2);
		tx3.setText(R.string.text_b);
	}
}