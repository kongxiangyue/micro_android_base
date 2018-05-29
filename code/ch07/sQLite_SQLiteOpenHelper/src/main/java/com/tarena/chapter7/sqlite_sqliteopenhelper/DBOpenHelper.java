package com.tarena.chapter7.sqlite_sqliteopenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBOpenHelper extends SQLiteOpenHelper {
	// 继承SQLiteOpenHelper 必须重写出至少一个构造方法，以及未实现的方法
	public DBOpenHelper(Context context, int version) {
		super(context, "stu.db", null, version);
	}
	@Override
	// 自动回调 不需要手动调用 当数据库首次创建时执行该方法 一般都把创建表 等初始化操作写在这里面
	// 只要数据库创建成功了就不再执行了
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.i("info", "onCreate()");
		db.execSQL("create table if not exists stutb1 (_id integer primary key autoincrement,name text not null,sex text not null,age integer not null)");
		db.execSQL("insert into stutb1(name,sex,age) values('张三','女',18)");
	}
	@Override
	// 自动回调 不需要手动调用 当打开的数据库版本号与原来的版本号不一致时会 回调该方法
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.i("info", "onUpgrade()");
	}
	// @Override//会在数据库每次打开时自动回调
	// public void onOpen(SQLiteDatabase db) {
	// // TODO Auto-generated method stub
	// super.onOpen(db);
	// }
}