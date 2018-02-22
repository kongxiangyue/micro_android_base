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
			dataList.add("ListView�������ݣ���" + i + "��");
		}
		// ����һ��ArrayAdapter����dataList��Ϊ����Դ ��ʹ��item.xml��ΪItem�Ĳ���
		adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.item,
				dataList);
		lv.setAdapter(adapter);
		// �����û������¼�
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> listView, View item,
					int position, long id) {
				// position��ֵ�Ǵ�0��ʼ
				Toast.makeText(MainActivity.this,
						"item" + (position + 1) + "�����", Toast.LENGTH_SHORT)
						.show();
			}
		});
		// �����û������¼�
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> listView, View item,
					int position, long id) {
				// ɾ�������µ�����
				dataList.remove(position);
				// ֪ͨAdapter�Ĺ۲�������Դ�ı��ˣ���������Ҳ�÷����仯
				adapter.notifyDataSetChanged();
				// ����true ��ʾ���ٻص������¼� false��ִ���곤���¼��󻹻�ص������¼�
				return true;
			}
		});
	}
}
