package com.example.demo36_listview;

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
	ListView mylistview;
	ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylistview  = (ListView) findViewById(R.id.listView1);
        String items [] = {"AAAAAAA","BBBBBBB","CCCCCCCC","DDDDDDDDD","AAAAAAA","BBBBBBB","CCCCCCCC","DDDDDDDDD","AAAAAAA","BBBBBBB","CCCCCCCC","DDDDDDDDD","AAAAAAA","BBBBBBB","CCCCCCCC","DDDDDDDDD","AAAAAAA","BBBBBBB","CCCCCCCC","DDDDDDDDD","AAAAAAA","BBBBBBB","CCCCCCCC","DDDDDDDDD","AAAAAAA","BBBBBBB","CCCCCCCC","DDDDDDDDD"};
        adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.item, items);
        mylistview.setAdapter(adapter);
        mylistview.setOnItemClickListener(new OnItemClickListener() {
//        	parent ��ʾ��ǰ�������������ListView����
//        	view	��ǰ�������Item
//        	position ��ǰ�������Item���±�ֵ
//        	id		��ǰ�������item��ID
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this, "ListView�����", Toast.LENGTH_SHORT).show();
				
			}
		});
        mylistview.setOnItemLongClickListener(new OnItemLongClickListener() {
//        	parent ��ʾ��ǰ�������������ListView����
//        	view	��ǰ�������Item
//        	position ��ǰ�������Item���±�ֵ
//        	id		��ǰ�������item��ID
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this, "ListView������", Toast.LENGTH_SHORT).show();
//				true ��ʾ�¼����� ���ٻص��̰��¼�
//				false ��ʾ�¼�δ���� ����ص��̰��¼�
				return true;
			}
		});
    }


    
}
