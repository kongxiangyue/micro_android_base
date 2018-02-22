package com.tarena.chapter6.baseadapter2;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends Activity {
	ListView lv;
	ArrayList<Music> musiclist;
	Music music;
	MusicAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.listView1);
		musiclist = new ArrayList<Music>();
		for (int i = 0; i <= 50; i++) {
			music = new Music(1001, R.drawable.ic_launcher, "everyDay", "�����ĸ�"
					+ i, "����", "02:34");
			musiclist.add(music);
		}
		adapter = new MusicAdapter(MainActivity.this, musiclist);
		lv.setAdapter(adapter);
		// �����û������¼�
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> listView, View item,
					int position, long id) {
				Music itemMusic = musiclist.get(position);
				// position��ֵ�Ǵ�0��ʼ
				Toast.makeText(MainActivity.this,
						"��ʼ����:" + itemMusic.getMusicName(), Toast.LENGTH_SHORT)
						.show();
			}
		});
		// �����û������¼�
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> listView, View item,
					int position, long id) {
				Music itemMusic = musiclist.get(position);
				// position��ֵ�Ǵ�0��ʼ
				Toast.makeText(MainActivity.this,
						"�Ѿ�ɾ��:" + itemMusic.getMusicName(), Toast.LENGTH_SHORT)
						.show();
				// ɾ�������µ�����
				musiclist.remove(position);
				// ֪ͨAdapter�Ĺ۲�������Դ�ı��ˣ���������Ҳ�÷����仯
				adapter.notifyDataSetChanged();
				// ����true ��ʾ���ٻص������¼� false��ִ���곤���¼��󻹻�ص������¼�
				return true;
			}
		});
	}
}