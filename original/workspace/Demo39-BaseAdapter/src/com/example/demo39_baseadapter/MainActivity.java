package com.example.demo39_baseadapter;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView mylistview;
	ArrayList<Music> musiclist;
	Music music;
	MusicAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mylistview = (ListView) findViewById(R.id.mylistview);

		musiclist = new ArrayList<Music>();
		for (int i = 0; i < 50; i++) {
			music = new Music(1001, R.drawable.ic_launcher, "ereryDay", "张三的歌", "张三的专辑", "02:34");
			musiclist.add(music);
		}
		adapter = new MusicAdapter(MainActivity.this, musiclist);
		mylistview.setAdapter(adapter);
		//ListView Item 点击事件
		mylistview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Music music = musiclist.get(position);

			}
		});
		
		//ListView Item 长按事件
		mylistview.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				Music music = musiclist.get(position);
				
				return true;
			}
		});
	}

}
