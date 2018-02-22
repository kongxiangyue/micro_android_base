package com.tarena.chapter7.sqlite_sqliteopenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBOpenHelper extends SQLiteOpenHelper {
	// �̳�SQLiteOpenHelper ������д������һ�����췽�����Լ�δʵ�ֵķ���
	public DBOpenHelper(Context context, int version) {
		super(context, "stu.db", null, version);
	}
	@Override
	// �Զ��ص� ����Ҫ�ֶ����� �����ݿ��״δ���ʱִ�и÷��� һ�㶼�Ѵ����� �ȳ�ʼ������д��������
	// ֻҪ���ݿⴴ���ɹ��˾Ͳ���ִ����
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.i("info", "onCreate()");
		db.execSQL("create table if not exists stutb1 (_id integer primary key autoincrement,name text not null,sex text not null,age integer not null)");
		db.execSQL("insert into stutb1(name,sex,age) values('����','Ů',18)");
	}
	@Override
	// �Զ��ص� ����Ҫ�ֶ����� ���򿪵����ݿ�汾����ԭ���İ汾�Ų�һ��ʱ�� �ص��÷���
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.i("info", "onUpgrade()");
	}
	// @Override//�������ݿ�ÿ�δ�ʱ�Զ��ص�
	// public void onOpen(SQLiteDatabase db) {
	// // TODO Auto-generated method stub
	// super.onOpen(db);
	// }
}