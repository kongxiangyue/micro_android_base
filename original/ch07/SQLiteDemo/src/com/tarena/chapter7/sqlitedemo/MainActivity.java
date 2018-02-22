package com.tarena.chapter7.sqlitedemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView lvMusics;
	MusicAdapter adapter;
	MusicBiz biz;
	ArrayList<Music> musics = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lvMusics = (ListView) findViewById(R.id.lvMusics);
		biz = new MusicBiz(MainActivity.this);
		musics = biz.getMusics();
		adapter = new MusicAdapter(MainActivity.this, musics);
		lvMusics.setAdapter(adapter);
		lvMusics.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Music music = musics.get(position);
				System.out.println("ÕýÔÚ²¥·Å£º" + music.getName());
			}
		});
	}
}
