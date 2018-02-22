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
		SQLiteDatabase db = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
		db.execSQL("create table if not exists usertb1 ("
				+ "_id integer primary key autoincrement,"
				+ "name text not null," + "age integer not null,"
				+ "sex text not null" + ")");
		
		db.execSQL("insert into usertb1(name,sex,age) values('张三','女',18)");
		db.execSQL("insert into usertb1(name,sex,age) values('李四','女',19)");
		db.execSQL("insert into usertb1(name,sex,age) values('王二','男',20)");
		db.execSQL("update usertb1 set sex='男' where _id=1");
		db.execSQL("delete from usertb1 where _id=2");
		//TODO SELECT
		Cursor c = db.rawQuery("select * from usertb1", null);
		if (c!=null) {
			while (c.moveToNext()) {
			Log.i("info", "_id:"+c.getInt(c.getColumnIndex("_id")));	
			Log.i("info", "name:"+c.getString(c.getColumnIndex("name")));	
			Log.i("info", "age:"+c.getInt(c.getColumnIndex("age")));
			Log.i("info", "sex:"+c.getString(c.getColumnIndex("sex")));
			}
			c.close();
		}
		db.close();
	}

}
