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
		builder.setTitle("�û���¼");
		builder.setIcon(R.drawable.ic_launcher);
		/* ��ȡ��layout������� */
		LayoutInflater li = this.getLayoutInflater();
		/*
		 * ͨ���������ȡ��/res/layout/dialog_sign .xml��������ļ���Ȼ���������ʽָ�����Ի���
		 */
		View v = li.inflate(R.layout.dialog_sign, null);
		builder.setView(v);
		// Button b = (Button) v.findViewById(R.id.mybt);
		// b.setOnClickListener(l);
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