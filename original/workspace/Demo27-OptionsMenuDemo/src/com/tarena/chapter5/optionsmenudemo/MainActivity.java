package com.tarena.chapter5.optionsmenudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		menu.add(0, 1, 2, "…Ë÷√").setIcon(R.drawable.ic_launcher);
		menu.add(0, 2, 1, "ÕÀ≥ˆ");
		
		return super.onCreateOptionsMenu(menu);
	}
}
