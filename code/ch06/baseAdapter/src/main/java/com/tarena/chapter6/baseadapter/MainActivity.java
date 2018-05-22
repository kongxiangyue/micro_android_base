package com.tarena.chapter6.baseadapter;
import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends Activity {
//	ListView lv;
	GridView gv;
	ArrayList<Music> musiclist;
	Music music;
	MusicAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		lv = (ListView) findViewById(R.id.listView1);
		gv = (GridView) findViewById(R.id.gridView1);
		musiclist = new ArrayList<Music>();
		for (int i = 0; i <= 50; i++) {
			music = new Music(1001, R.drawable.ic_launcher, "everyDay", "张三的歌"
					+ i, "张三", "02:34");
			musiclist.add(music);
		}
		adapter = new MusicAdapter(MainActivity.this, musiclist);
		gv.setAdapter(adapter);
		// 处理用户单击事件
		gv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> listView, View item,
					int position, long id) {
				Music itemMusic = musiclist.get(position);
				// position的值是从0开始
				Toast.makeText(MainActivity.this,
						"开始播放:" + itemMusic.getMusicName(), Toast.LENGTH_SHORT)
						.show();
			}
		});
		// 处理用户长按事件
		gv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> listView, View item,
					int position, long id) {
				Music itemMusic = musiclist.get(position);
				// position的值是从0开始
				Toast.makeText(MainActivity.this,
						"已经删除:" + itemMusic.getMusicName(), Toast.LENGTH_SHORT)
						.show();
				// 删除被按下的数据
				musiclist.remove(position);
				// 通知Adapter的观察者数据源改变了，界面内容也得发生变化
				adapter.notifyDataSetChanged();
				// 返回true 表示不再回调单击事件 false在执行完长按事件后还会回调单击事件
				return true;
			}
		});
	}
}