package com.example.demo23_alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// bt.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		//
		// }
		// });

		AlertDialog.Builder bulider = new AlertDialog.Builder(MainActivity.this);
		bulider.setTitle("对话框的标题");
		bulider.setMessage("对话框的提示信息");
		bulider.setIcon(R.drawable.ic_launcher);
		bulider.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "对话框中的按钮被取消",
						Toast.LENGTH_SHORT).show();
			}
		});
		bulider.setNegativeButton("取消", null);
		// bulider.setView(view);
		bulider.create();
		bulider.show();

	}

}
