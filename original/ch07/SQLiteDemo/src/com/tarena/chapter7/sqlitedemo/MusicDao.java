package com.tarena.chapter7.sqlitedemo;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MusicDao {
	DBOpenHelper helper;
	public MusicDao(Context context) {
		helper = new DBOpenHelper(context);
	}
	// ��ѯ���ݿ� ���һ�ȡ���� ���ص� List����
	public ArrayList<Music> getMusics() {
		ArrayList<Music> musics = null;
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.rawQuery("select * from musictb1", null);
		if (c != null) {
			musics = new ArrayList<Music>();// �����������ȥnew ����
			while (c.moveToNext()) {
				Music music = new Music();
				music.setId(c.getInt(c.getColumnIndex("_id")));
				music.setName(c.getString(c.getColumnIndex("name")));
				music.setAlbum(c.getString(c.getColumnIndex("album")));
				music.setSinger(c.getString(c.getColumnIndex("singer")));
				music.setDuration(c.getLong(c.getColumnIndex("duration")));
				musics.add(music);
			}
			c.close();
		}
		db.close();
		return musics;
	}
}
