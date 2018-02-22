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
//        	parent 表示当前发生点击操作的ListView对象
//        	view	当前被点击的Item
//        	position 当前被点击的Item的下标值
//        	id		当前被点击的item的ID
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this, "ListView被点击", Toast.LENGTH_SHORT).show();
				
			}
		});
        mylistview.setOnItemLongClickListener(new OnItemLongClickListener() {
//        	parent 表示当前发生点击操作的ListView对象
//        	view	当前被点击的Item
//        	position 当前被点击的Item的下标值
//        	id		当前被点击的item的ID
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this, "ListView被长按", Toast.LENGTH_SHORT).show();
//				true 表示事件结束 不再回调短按事件
//				false 表示事件未结束 还会回调短按事件
				return true;
			}
		});
    }


    
}
