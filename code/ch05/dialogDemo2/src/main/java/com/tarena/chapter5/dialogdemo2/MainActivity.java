package com.tarena.chapter5.dialogdemo2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("用户登录");
		builder.setIcon(R.drawable.ic_launcher);
		/* 获取到layout的填充器 */
		LayoutInflater li = this.getLayoutInflater();
		/*
		 * 通过填充器获取到/res/layout/dialog_sign .xml这个布局文件，然后将其界面样式指定给对话框
		 */
		View v = li.inflate(R.layout.dialog_sign, null);
		builder.setView(v);
		// Button b = (Button) v.findViewById(R.id.mybt);
		// b.setOnClickListener(l);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				/*
				 * 在这里编写处理点击“确定” 按钮的事件
				 */
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				/*
				 * 在这里编写处理点击“取消” 按钮的事件
				 */
			}
		});
		builder.create();
		builder.show();

	}

}