package com.tarena.chapter5.dialogdemo2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("�û���¼");
		builder.setIcon(R.drawable.ic_launcher);
		LayoutInflater li = this.getLayoutInflater();
		View view = li.inflate(R.layout.dialog_sign, null);
		
		Button bt = (Button)view.findViewById(R.id.mybt);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			}
		});
		builder.setView(view);
		
		
		
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				/*
				 * �������д��������ȷ���� ��ť���¼�
				 */
			}
		});
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				/*
				 * �������д��������ȡ���� ��ť���¼�
				 */
			}
		});
		builder.create();
		builder.show();

	}

}