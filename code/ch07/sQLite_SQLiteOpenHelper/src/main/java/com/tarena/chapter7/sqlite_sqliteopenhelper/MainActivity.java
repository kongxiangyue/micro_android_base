package com.tarena.chapter7.sqlite_sqliteopenhelper;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// SQLiteOpenHelper
		// SQLiteOpenHelper是Android提供的数据库辅助类 提供了对数据库的创建和版本的管理
		// 用法是 继承该抽象类 实现必要的抽象方法 以及规定的构造方法
		DBOpenHelper helper = new DBOpenHelper(MainActivity.this, 2);
		// helper.getReadableDatabase() 这个方法返回的并不总是只读的数据库
		// 一般跟getWritableDatabase()返回的情况相同
		// getReadableDatabase(); 在数据库仅开放读取权限或者磁盘满了数据无法写入就会返回一个只读的数据库
		SQLiteDatabase db = helper.getReadableDatabase();
		// db.rawQuery(sql, selectionArgs);//
		// db.query(table, columns, selection, selectionArgs, groupBy, having,
		// orderBy)
		Cursor c = db.rawQuery("select * from stutb1", null);
		if (c != null) {
			String[] cols = c.getColumnNames();
			while (c.moveToNext()) {
				for (String ColumnName : cols) {
					Log.i("info",
							ColumnName + ":"
									+ c.getString(c.getColumnIndex(ColumnName)));
				}
			}
			c.close();
		}
		db.close();
	}
}