package com.tarena.chapter5.contextmenudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bt = (Button) findViewById(R.id.mybt);
		registerForContextMenu(bt);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(Menu.NONE, 1, Menu.NONE, "Item1");
		menu.add(Menu.NONE, 2, Menu.NONE, "Item2");
		menu.add(Menu.NONE, 3, Menu.NONE, "Item3");
		menu.add(Menu.NONE, 4, Menu.NONE, "Item4");
		menu.add(Menu.NONE, 5, Menu.NONE, "Item5");

		SubMenu subMenu = menu.addSubMenu(Menu.NONE, 6, Menu.NONE, "Item6");
		subMenu.setHeaderIcon(R.drawable.ic_launcher);
		subMenu.setIcon(R.drawable.ic_launcher);
		subMenu.setHeaderTitle("上下文中的子菜单");
		subMenu.add(Menu.NONE, 61, Menu.NONE, "Item6-1");
		subMenu.add(Menu.NONE, 62, Menu.NONE, "Item6-2");
		subMenu.add(Menu.NONE, 63, Menu.NONE, "Item6-3");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case 1:
			/*
			 * 此处可以处理MenuId为1的菜单项
			 */
			break;

		case 61:
			/*
			 * 此处可以处理MenuId为61的菜单项
			 */
			break;
		}
		return super.onContextItemSelected(item);
	}

}
