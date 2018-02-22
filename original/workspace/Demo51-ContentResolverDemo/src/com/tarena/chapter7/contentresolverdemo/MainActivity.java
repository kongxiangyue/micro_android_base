package com.tarena.chapter7.contentresolverdemo;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// com.provider.music
		Uri uri = Uri.parse("content://com.provider.music/music");
		ContentResolver cr = getContentResolver();
		ContentValues values = new ContentValues();
		//��
		values.put("name", "K��֮��1");
		values.put("album", "���������ҡ�");
		values.put("singer", "����Ѹ");
		values.put("duration", 198000);
		cr.insert(uri, values);
		values.clear();
		values.put("name", "K��֮��2");
		values.put("album", "���������ҡ�");
		values.put("singer", "����Ѹ");
		values.put("duration", 198000);
		cr.insert(uri, values);
		values.clear();
		values.put("name", "K��֮��3");
		values.put("album", "���������ҡ�");
		values.put("singer", "����Ѹ");
		values.put("duration", 198000);
		cr.insert(uri, values);
		values.clear();
		values.put("name", "K��֮��4");
		values.put("album", "���������ҡ�");
		values.put("singer", "����Ѹ");
		values.put("duration", 198000);
		cr.insert(uri, values);
		//��
		values.clear();
		values.put("name", "K��֮��40");
		cr.update(uri, values, "name=?", new String[] { "K��֮��4" });
		values.clear();
		values.put("name", "K��֮��5");
		// cr.update(uri, values, "_id=1", null);
		cr.update(ContentUris.withAppendedId(uri, 1), values, null, null);
		//ɾ
		cr.delete(ContentUris.withAppendedId(uri, 3), null, null);
		//��
		Cursor c = cr.query(uri, null, null, null, null);
		if (c != null) {
			String[] cols = c.getColumnNames();
			while (c.moveToNext()) {
				for (String columnName : cols) {
					Log.i("info",
							columnName + ":"
									+ c.getString(c.getColumnIndex(columnName)));
				}
			}
			c.close();
		}
	}
}