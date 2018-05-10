package com.tarena.chapter5.submenudemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.SubMenu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, 1, Menu.NONE, "item1");
		menu.add(Menu.NONE, 2, Menu.NONE, "item2");
		menu.add(Menu.NONE, 3, Menu.NONE, "item3");
		menu.add(Menu.NONE, 4, Menu.NONE, "item4");

		SubMenu subMenu = menu.addSubMenu(Menu.NONE, 5, Menu.NONE, "item5");
		subMenu.setHeaderIcon(R.drawable.ic_launcher);
		subMenu.setHeaderTitle("子菜单");
		subMenu.setIcon(R.drawable.ic_launcher);
		subMenu.add(Menu.NONE, 51, Menu.NONE, "item5-1");
		subMenu.add(Menu.NONE, 52, Menu.NONE, "item5-2");
		menu.add(Menu.NONE, 6, Menu.NONE, "item6");
		menu.add(Menu.NONE, 7, Menu.NONE, "item7");
		return true;
	}

}
