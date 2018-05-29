package com.tarena.chapter7.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
	public static final String DBNAME = "music.db";
	public static final int DBVERSION = 1;
	public DBOpenHelper(Context context) {
		super(context, DBNAME, null, DBVERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table if not exists musictb1(_id integer primary key autoincrement,name text not null,album text not null,singer text not null,duration integer not null)");
		ContentValues values = new ContentValues();
		values.put("name", "我唱故我在");
		values.put("album", "吉克隽逸的歌");
		values.put("singer", "吉克隽逸");
		values.put("duration", 189000);
		db.insert("musictb1", null, values);
		values.clear();
		values.put("name", "天使的指纹");
		values.put("album", "孙燕姿的歌");
		values.put("singer", "孙燕姿");
		values.put("duration", 289000);
		db.insert("musictb1", null, values);
		values.clear();
		values.put("name", "我唱故我在");
		values.put("album", "吉克隽逸的歌");
		values.put("singer", "吉克隽逸");
		values.put("duration", 189000);
		db.insert("musictb1", null, values);
		values.clear();
		values.put("name", "天使的指纹");
		values.put("album", "孙燕姿的歌");
		values.put("singer", "孙燕姿");
		values.put("duration", 289000);
		db.insert("musictb1", null, values);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}
