package com.tarena.chapter7.sqlite_openorcreatedatabase;

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
		// 创建并打开数据库
		SQLiteDatabase db = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
		// 创建表
		// SQLite 只支持4种数据类型：integer（int...） text(String char verchar ...)
		// real(flat double ...) blob(other)
		db.execSQL("create table if not exists usertb1 ("
				+ "_id integer primary key autoincrement,"
				+ "name text not null," + "age integer not null,"
				+ "sex text not null" + ")");
		db.execSQL("insert into usertb1(name,sex,age) values('张三','女',18)");
		db.execSQL("insert into usertb1(name,sex,age) values('李四','女',19)");
		db.execSQL("insert into usertb1(name,sex,age) values('王二','男',20)");
		db.execSQL("update usertb1 set sex='男' where _id=1");
		db.execSQL("delete from usertb1 where _id=2");
		// 查询
		Cursor c = db.rawQuery("select * from usertb1", null); 
		// sql 查询语句
		// selectionArgs查询条件
		// db.rawQuery("select * from usertb1 where _id>?", new String []{"1"});
		// //== select * from usertb1 where _id>1
		// 游标 如果查询出有数据 游标对象就存在 一条条访问数据 通过游标去遍历
		if (c != null) {// 如果查询出来有数据
			while (c.moveToNext()) {// 一条一条去访问数据
			// Column//列
			// c.getColumnIndex("_id");//表示取出_id列的数据
			// System.out.println("getColumnIndex:"+c.getColumnIndex("name"));
			// c.getString(c.getColumnIndex("name"));
			// System.out.println(c.getString(c.getColumnIndex("name")));
				Log.i("info", "_id:" + c.getInt(c.getColumnIndex("_id")));
				Log.i("info", "name:" + c.getString(c.getColumnIndex("name")));
				Log.i("info", "age:" + c.getInt(c.getColumnIndex("age")));
				Log.i("info", "sex:" + c.getString(c.getColumnIndex("sex")));
			}
			c.close();
		} else {
			db.close();
		}
	}
	/*
	 * SQLite 小 资源消耗少 没有服务端-客户端的概念 服务端-客户端全部在一个APP里 每个程序自己的数据库
	 * data/data/包名/databases/***.db 没有系统级别的数据库
	 */

}
