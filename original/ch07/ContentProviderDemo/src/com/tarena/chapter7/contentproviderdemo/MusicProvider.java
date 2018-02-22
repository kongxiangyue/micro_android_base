package com.tarena.chapter7.contentproviderdemo;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
public class MusicProvider extends ContentProvider {
	static UriMatcher matcher;
	DBOpenHelper helper;
	static {
		matcher = new UriMatcher(UriMatcher.NO_MATCH);
		matcher.addURI("com.provider.music", "music", 1);
		// content://com.provider.music/music
		matcher.addURI("com.provider.music", "music/#", 2);
		// content://com.provider.music/music/3
	}
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		String where = null;
		switch (matcher.match(uri)) {
		case 1:
			where = selection;
			break;
		case 2:
			long id = ContentUris.parseId(uri);
			where = "_id=" + id;
			if (selection != null) {
				where = where + "and(" + selection + ")";
			}
			break;
		default:
			throw new IllegalArgumentException("未知URI：" + uri);
		}
		SQLiteDatabase db = helper.getWritableDatabase();
		int count = db.delete("musictb1", where, selectionArgs);
		db.close();
		return count;
	}
	@Override
	public String getType(Uri uri) {
		return null;
	}
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		if (matcher.match(uri) != 1) {
			throw new IllegalArgumentException("未知uri:" + uri);
		}
		SQLiteDatabase db = helper.getWritableDatabase();
		long rowId = db.insert("musictb1", null, values);
		uri = ContentUris.withAppendedId(uri, rowId);
		db.close();
		return uri;
	}
	@Override
	public boolean onCreate() {
		helper = new DBOpenHelper(this.getContext());
		if (helper == null) {
			return false;
		}
		return true;
	}
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		String where = null;
		switch (matcher.match(uri)) {
		case 1:// 多条数据
			where = selection;
			break;
		case 2:// 单条数据
			long id = ContentUris.parseId(uri);
			// String id = uri.getLastPathSegment();
			where = "_id=" + id;
			if (selection != null)
				where = where + " and (" + selection + ")";
			break;
		default:
			throw new IllegalArgumentException("未知uri : " + uri);
		}
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.query("musictb1", projection, where, selectionArgs, null,
				null, sortOrder);
		return c;
	}
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		String where = null;
		switch (matcher.match(uri)) {
		case 1:// 多条数据
			where = selection;
			break;
		case 2:// 单条数据
			long id = ContentUris.parseId(uri);
			// String id = uri.getLastPathSegment();
			where = "_id=" + id;
			if (selection != null)
				where = where + " and (" + selection + ")";
			break;
		default:
			throw new IllegalArgumentException("未知uri : " + uri);
		}
		SQLiteDatabase db = helper.getWritableDatabase();
		int count = db.update("musictb1", values, where, selectionArgs);
		db.close();
		return count;
	}
}