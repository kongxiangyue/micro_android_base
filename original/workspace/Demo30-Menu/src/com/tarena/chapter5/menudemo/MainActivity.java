package com.tarena.chapter5.menudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/*
		 * add()方法的四个参数，依次是： 1、组别，如果不分组的话就写Menu.NONE,
		 * 2、Id，这个很重要，Android根据这个Id来确定不同的菜单 3、顺序，那个菜单现在在前面由这个参数的大小决定
		 * 4、文本，菜单的显示文本
		 */
		// setIcon()方法为菜单设置图标，这里使用的是系统自带的图标，以
		// android.R开头的资源是系统提供的，我们自己提供的资源是以R开头的
		menu.add(Menu.NONE, Menu.FIRST + 1, 5, "刷新曲库").setIcon(
				android.R.drawable.ic_menu_search);
		menu.add(Menu.NONE, Menu.FIRST + 2, 6, "退出").setIcon(
				android.R.drawable.ic_menu_set_as);
		menu.add(Menu.NONE, Menu.FIRST + 3, 2, "帮助").setIcon(
				android.R.drawable.ic_menu_help);
		menu.add(Menu.NONE, Menu.FIRST + 4, 1, "列表").setIcon(
				android.R.drawable.ic_menu_agenda);
		menu.add(Menu.NONE, Menu.FIRST + 5, 4, "关于").setIcon(
				android.R.drawable.ic_menu_info_details);
		menu.add(Menu.NONE, Menu.FIRST + 6, 3, "设置").setIcon(
				android.R.drawable.ic_menu_preferences);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case Menu.FIRST + 1:
			Toast.makeText(MainActivity.this, "刷新曲库中...", Toast.LENGTH_LONG).show();
			break;
		case Menu.FIRST + 2:
			finish();
			break;
		case Menu.FIRST + 3:
			
			break;
		case Menu.FIRST + 4:
			
			break;
		case Menu.FIRST + 5:
			
			break;
		case Menu.FIRST + 6:
			
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	// @Override
	// public boolean onContextItemSelected(MenuItem item) {
	// // TODO Auto-generated method stub
	// return super.onContextItemSelected(item);
	// }

}