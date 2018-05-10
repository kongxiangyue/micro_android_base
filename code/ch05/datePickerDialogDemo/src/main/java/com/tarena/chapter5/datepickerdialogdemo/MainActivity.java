package com.tarena.chapter5.datepickerdialogdemo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	private DatePicker dpSet;
	private DatePickerDialog dialog;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 加载控件
		dpSet = (DatePicker) findViewById(R.id.dpSet);
		// 初始化dpSet
		dpSet.init(2015, 0, 19, new OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				// TODO Auto-generated method stub
				Toast.makeText(
						MainActivity.this,
						"您设置的时间是 : " + year + "年" + (monthOfYear + 1) + "月"
								+ dayOfMonth + "日", 3000).show();
			}
		});

		dialog = new DatePickerDialog(this, new OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				Toast.makeText(
						MainActivity.this,
						"您设置的时间是 : " + year + "年" + (monthOfYear + 1) + "月"
								+ dayOfMonth + "日", 3000).show();
			}
		}, 2015, 0, 19);
	}

	public void doClick(View v) {
		dialog.show();
	}
}