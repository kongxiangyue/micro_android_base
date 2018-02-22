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
			data.put("musicAlbum", "�����ĸ�");
			data.put("musicSinger", "����");
			data.put("musicDuration", "01:23");
			listData.add(data);
		}
		String [] from = {"musicImg","musicName","musicAlbum","musicSinger","musicDuration"};
		int [] to = {R.id.img,R.id.musicName,R.id.albumName,R.id.singer,R.id.duration};
		 adapter = new SimpleAdapter(MainActivity.this, listData, R.layout.item, from, to);
		lv.setAdapter(adapter);
		//�����û������¼�
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> listView, View item, int position,
					long id) {
				HashMap<String, Object> itemData = listData.get(position);
				//position��ֵ�Ǵ�0��ʼ
				Toast.makeText(MainActivity.this, "��ʼ����:"+itemData.get("musicName"), Toast.LENGTH_SHORT).show();
			}
		});
		//�����û������¼�
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> listView, View item, int position,
					long id) {
				//ɾ�������µ�����
				listData.remove(position);
				//֪ͨAdapter�Ĺ۲�������Դ�ı��ˣ���������Ҳ�÷����仯
				adapter.notifyDataSetChanged();
				//����true ��ʾ���ٻص������¼�  false��ִ���곤���¼��󻹻�ص������¼�
				return true;
			}
		});
	}

}

