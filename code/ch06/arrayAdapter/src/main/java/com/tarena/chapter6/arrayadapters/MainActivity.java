package com.tarena.chapter6.arrayadapters;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView lv;
		final ArrayList<String> dataList = new ArrayList<String>();
		final ArrayAdapter<String> adapter;
		lv = (ListView) findViewById(R.id.lv);
		for (int i = 1; i <= 50; i++) {
			dataList.add("ListView测试数据，第" + i + "项");
		}
		// 定义一个ArrayAdapter，将dataList作为数据源 且使用item.xml作为Item的布局
		adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.item,
				dataList);
		lv.setAdapter(adapter);
		// 处理用户单击事件
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> listView, View item,
					int position, long id) {
				// position的值是从0开始
				Toast.makeText(MainActivity.this,
						"item" + (position + 1) + "被点击", Toast.LENGTH_SHORT)
						.show();
			}
		});
		// 处理用户长按事件
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> listView, View item,
					int position, long id) {
				// 删除被按下的数据
				dataList.remove(position);
				// 通知Adapter的观察者数据源改变了，界面内容也得发生变化
				adapter.notifyDataSetChanged();
				// 返回true 表示不再回调单击事件 false在执行完长按事件后还会回调单击事件
				return true;
			}
		});
	}
}
