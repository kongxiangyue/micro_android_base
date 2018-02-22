package com.tarena.chapter02.lifecyle;

import com.example.com.tarena.chapter02.lifecyle.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	private static final String LOG_TAG = "ActivityLifeCycle";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(LOG_TAG, "onCreate方法被调用");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(LOG_TAG, "onStart方法被调用");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(LOG_TAG, "onResume方法被调用");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(LOG_TAG, "onPause方法被调用");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(LOG_TAG, "onStop方法被调用");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(LOG_TAG, "onDestroy方法被调用");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(LOG_TAG, "onRestart方法被调用");
	}

}