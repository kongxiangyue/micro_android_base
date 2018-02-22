package com.tarena.chapter7.sqlite_sqliteopenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class DBOpenHelper extends SQLiteOpenHelper {

	public DBOpenHelper(Context context, CursorFactory factory,
			int version) {
		super(context, "stu.db", null, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table if not exists stutb1( _id integer primary key autoincrement,name text not null,age integer not null,sex text not null)");
		db.execSQL("insert into stutb1(name,sex,age) values('ÕÅÈý','Å®','18')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
}