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
		Log.i(LOG_TAG, "onCreate����������");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(LOG_TAG, "onStart����������");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(LOG_TAG, "onResume����������");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(LOG_TAG, "onPause����������");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(LOG_TAG, "onStop����������");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(LOG_TAG, "onDestroy����������");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(LOG_TAG, "onRestart����������");
	}

}