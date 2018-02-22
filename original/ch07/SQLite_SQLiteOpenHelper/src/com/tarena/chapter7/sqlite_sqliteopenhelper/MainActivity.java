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
		// SQLiteOpenHelper��Android�ṩ�����ݿ⸨���� �ṩ�˶����ݿ�Ĵ����Ͱ汾�Ĺ���
		// �÷��� �̳иó����� ʵ�ֱ�Ҫ�ĳ��󷽷� �Լ��涨�Ĺ��췽��
		DBOpenHelper helper = new DBOpenHelper(MainActivity.this, 2);
		// helper.getReadableDatabase() ����������صĲ�������ֻ�������ݿ�
		// һ���getWritableDatabase()���ص������ͬ
		// getReadableDatabase(); �����ݿ�����Ŷ�ȡȨ�޻��ߴ������������޷�д��ͻ᷵��һ��ֻ�������ݿ�
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