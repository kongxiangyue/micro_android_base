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
		bulider.setTitle("�Ի���ı���");
		bulider.setMessage("�Ի������ʾ��Ϣ");
		bulider.setIcon(R.drawable.ic_launcher);
		bulider.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "�Ի����еİ�ť��ȡ��",
						Toast.LENGTH_SHORT).show();
			}
		});
		bulider.setNegativeButton("ȡ��", null);
		// bulider.setView(view);
		bulider.create();
		bulider.show();

	}

}
