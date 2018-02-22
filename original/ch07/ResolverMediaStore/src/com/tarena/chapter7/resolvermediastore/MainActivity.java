package com.tarena.chapter7.resolvermediastore;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView lvMusics;
	MusicBiz biz;
	MusicAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lvMusics = (ListView) findViewById(R.id.lvMusics);
		biz = new MusicBiz(MainActivity.this);
		ArrayList<Music> musics = biz.getMusicInfos();
		adapter = new MusicAdapter(MainActivity.this, musics);
		lvMusics.setAdapter(adapter);
	}
}
