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
		 * add()�������ĸ������������ǣ� 1��������������Ļ���дMenu.NONE,
		 * 2��Id���������Ҫ��Android�������Id��ȷ����ͬ�Ĳ˵� 3��˳���Ǹ��˵�������ǰ������������Ĵ�С����
		 * 4���ı����˵�����ʾ�ı�
		 */
		// setIcon()����Ϊ�˵�����ͼ�꣬����ʹ�õ���ϵͳ�Դ���ͼ�꣬��
		// android.R��ͷ����Դ��ϵͳ�ṩ�ģ������Լ��ṩ����Դ����R��ͷ��
		menu.add(Menu.NONE, Menu.FIRST + 1, 5, "ˢ������").setIcon(
				android.R.drawable.ic_menu_search);
		menu.add(Menu.NONE, Menu.FIRST + 2, 6, "�˳�").setIcon(
				android.R.drawable.ic_menu_set_as);
		menu.add(Menu.NONE, Menu.FIRST + 3, 2, "����").setIcon(
				android.R.drawable.ic_menu_help);
		menu.add(Menu.NONE, Menu.FIRST + 4, 1, "�б�").setIcon(
				android.R.drawable.ic_menu_agenda);
		menu.add(Menu.NONE, Menu.FIRST + 5, 4, "����").setIcon(
				android.R.drawable.ic_menu_info_details);
		menu.add(Menu.NONE, Menu.FIRST + 6, 3, "����").setIcon(
				android.R.drawable.ic_menu_preferences);
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		// �����Menu.FIRST��һ������ Id�ı�ʾ
		// ���ݵõ���ID�ж� ��ǰ�Ǹ��˵������
		case Menu.FIRST + 1:
			Toast.makeText(MainActivity.this, "ˢ�²˵��������", Toast.LENGTH_SHORT).show();
			break;
		case Menu.FIRST + 2:
			MainActivity.this.finish();// ������ǰactivity
			break;
		case Menu.FIRST + 3:
			Toast.makeText(this, "�����˵��������", Toast.LENGTH_SHORT).show();
			break;
		case Menu.FIRST + 4:// ��ת�������б�
			Toast.makeText(this, "�б�˵��������", Toast.LENGTH_SHORT).show();
			break;
		case Menu.FIRST + 5:
			Toast.makeText(this, "���ڲ˵��������", Toast.LENGTH_SHORT).show();
			break;
		case Menu.FIRST + 6:
			Toast.makeText(this, "���ò˵��������", Toast.LENGTH_SHORT).show();
			break;
		}
		return false;
	}

}