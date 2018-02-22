package com.tarena.chapter7.sqlite_sqliteopenhelper;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DBOpenHelper openhelper = new DBOpenHelper(MainActivity.this, null, 1);
		SQLiteDatabase db = openhelper.getWritableDatabase();
	}
}