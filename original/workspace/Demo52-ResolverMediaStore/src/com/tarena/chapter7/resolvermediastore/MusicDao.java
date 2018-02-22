package com.tarena.chapter7.resolvermediastore;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

public class MusicDao {
	ContentResolver cr;
//	ContentResolver 根据URI 解析 ContentProvider提供好的数据接口
	public MusicDao(Context context) {
		cr =  context.getContentResolver();
	}
	// 查询内存卡上 时长大于20s的所有歌曲信息
	public ArrayList<Music> search() {
		ArrayList<Music> musics = null;
		String [] projection = {"_id","title","_data","duration","artist","album","composer","album_key"};
		Cursor c = cr.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projection, "duration>20000", null, null);
		if (c!=null) {
			//查询出所有的歌曲对象并且加入到集合里
			musics = new ArrayList<Music>();
			while (c.moveToNext()) {
				Music music = new Music();
					music.setId(c.getInt(c.getColumnIndex("_id")));
					music.setTitle(c.getString(c.getColumnIndex("title")));
					music.setAlbum(c.getString(c.getColumnIndex("album")));
					music.setSinger(c.getString(c.getColumnIndex("artist")));
					music.setComposer(c.getString(c.getColumnIndex("composer")));
					music.setDuration(c.getLong(c.getColumnIndex("duration")));
					music.setMusicPath(c.getString(c.getColumnIndex("_data")));
					//获取ambum_key
					String album_key = c.getString(c.getColumnIndex("album_key"));
					Cursor albumCursor = cr.query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, new String[]{"album_art"}, "album_key=?", new String[]{album_key}, null);
					if (albumCursor!=null&&albumCursor.moveToFirst()) {
						music.setAlbum_path(albumCursor.getString(0));
						albumCursor.close();
					}
					musics.add(music);
			}
			c.close();
		}
		return musics;
	}
}
