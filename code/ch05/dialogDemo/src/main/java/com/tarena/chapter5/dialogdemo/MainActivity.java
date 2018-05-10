package com.tarena.chapter5.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void alert(View v) {
		//AlertDialog.Builder builder = new AlertDialog.Builder(this);
		//builder.setTitle("Dialog Test"); /* 设置标题 */
		//builder.setMessage("这里是提示信息"); /* 设    置提示信息 */
		//builder.setIcon(R.drawable.ic_launcher); /* 加载图标 */
		//builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
		//	@Override
		//	public void onClick(DialogInterface dialog, int which) {
		//		// “确定”按钮事件
		//	}
		//});
		//builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
		//	@Override
		//	public void onClick(DialogInterface dialog, int which) {
		//		// “取消”按钮事件
		//	}
		//});
		//builder.create();
		//builder.show();





	}

}
