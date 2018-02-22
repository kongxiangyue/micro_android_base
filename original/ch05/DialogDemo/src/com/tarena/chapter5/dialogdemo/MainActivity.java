package com.tarena.chapter5.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Dialog Test"); /* ���ñ��� */
		builder.setMessage("��������ʾ��Ϣ"); /* ��    ����ʾ��Ϣ */
		builder.setIcon(R.drawable.ic_launcher); /* ����ͼ�� */
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// ��ȷ������ť�¼�
			}
		});
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// ��ȡ������ť�¼�
			}
		});
		builder.create();
		builder.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
