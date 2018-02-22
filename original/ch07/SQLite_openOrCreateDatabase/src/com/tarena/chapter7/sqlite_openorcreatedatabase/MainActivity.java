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
		// �����������ݿ�
		SQLiteDatabase db = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
		// ������
		// SQLite ֻ֧��4���������ͣ�integer��int...�� text(String char verchar ...)
		// real(flat double ...) blob(other)
		db.execSQL("create table if not exists usertb1 ("
				+ "_id integer primary key autoincrement,"
				+ "name text not null," + "age integer not null,"
				+ "sex text not null" + ")");
		db.execSQL("insert into usertb1(name,sex,age) values('����','Ů',18)");
		db.execSQL("insert into usertb1(name,sex,age) values('����','Ů',19)");
		db.execSQL("insert into usertb1(name,sex,age) values('����','��',20)");
		db.execSQL("update usertb1 set sex='��' where _id=1");
		db.execSQL("delete from usertb1 where _id=2");
		// ��ѯ
		Cursor c = db.rawQuery("select * from usertb1", null); 
		// sql ��ѯ���
		// selectionArgs��ѯ����
		// db.rawQuery("select * from usertb1 where _id>?", new String []{"1"});
		// //== select * from usertb1 where _id>1
		// �α� �����ѯ�������� �α����ʹ��� һ������������ ͨ���α�ȥ����
		if (c != null) {// �����ѯ����������
			while (c.moveToNext()) {// һ��һ��ȥ��������
			// Column//��
			// c.getColumnIndex("_id");//��ʾȡ��_id�е�����
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
	 * SQLite С ��Դ������ û�з����-�ͻ��˵ĸ��� �����-�ͻ���ȫ����һ��APP�� ÿ�������Լ������ݿ�
	 * data/data/����/databases/***.db û��ϵͳ��������ݿ�
	 */

}
