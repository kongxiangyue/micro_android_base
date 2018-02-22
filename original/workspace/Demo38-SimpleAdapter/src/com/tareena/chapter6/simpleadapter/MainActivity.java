package com.tareena.chapter6.simpleadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView lv;
	List<HashMap<String,Object>> listData = new ArrayList<HashMap<String,Object>>();
	HashMap<String,Object> data;
	SimpleAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.lv);
		for (int i = 1; i <=50; i++) {
			data = new HashMap<String, Object>();
			data.put("musicImg", R.drawable.ic_launcher);
			data.put("musicName", "everyDay"+i);
			data.put("musicAlbum", "张三的歌");
			data.put("musicSinger", "张三");
			data.put("musicDuration", "01:23");
			listData.add(data);
		}
		String [] from = {"musicImg","musicName","musicAlbum","musicSinger","musicDuration"};
		int [] to = {R.id.img,R.id.musicName,R.id.albumName,R.id.singer,R.id.duration};
		 adapter = new SimpleAdapter(MainActivity.this, listData, R.layout.item, from, to);
		lv.setAdapter(adapter);
		//处理用户单击事件
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> listView, View item, int position,
					long id) {
				HashMap<String, Object> itemData = listData.get(position);
				//position的值是从0开始
				Toast.makeText(MainActivity.this, "开始播放:"+itemData.get("musicName"), Toast.LENGTH_SHORT).show();
			}
		});
		//处理用户长按事件
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> listView, View item, int position,
					long id) {
				//删除被按下的数据
				listData.remove(position);
				//通知Adapter的观察者数据源改变了，界面内容也得发生变化
				adapter.notifyDataSetChanged();
				//返回true 表示不再回调单击事件  false在执行完长按事件后还会回调单击事件
				return true;
			}
		});
	}

}

