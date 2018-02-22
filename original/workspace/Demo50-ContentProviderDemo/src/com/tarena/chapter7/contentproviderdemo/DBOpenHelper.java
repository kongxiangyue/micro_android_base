package com.tarena.chapter7.contentproviderdemo;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DBOpenHelper extends SQLiteOpenHelper {
	public static final String DBNAME = "music.db";
	public static final int DBVERSION = 1;
	public static final String TABLENAME = "musictb1";
	public DBOpenHelper(Context context) {
		super(context, DBNAME, null, DBVERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table if not exists musictb1(_id integer primary key autoincrement,name text not null,album text not null,duration integer not null,singer text not null)");
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}