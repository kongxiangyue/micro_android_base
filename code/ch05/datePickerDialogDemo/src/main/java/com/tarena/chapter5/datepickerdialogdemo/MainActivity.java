package com.tarena.chapter5.datepickerdialogdemo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Toast;



// 如何实例化一个datapicker对话框 5个参数
// MainActivity.this
// 监听器(已经提供所选择的年月日)
// 初始化的年月日

// 如何弹出 (实例化成功后)直接调用show(不要调用create)

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

		OnDateSetListener onDateSetListener = new OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
								  int dayOfMonth) {
				// TODO Auto-generated method stub
				Toast.makeText(
						MainActivity.this,
						"您设置的时间是 : " + year + "年" + (monthOfYear + 1) + "月"
								+ dayOfMonth + "日", Toast.LENGTH_SHORT).show();
			}
		};

		dialog = new DatePickerDialog(this
				,onDateSetListener , 2015, 0, 19);
	}

	public void doClick(View v) {

		//弹出,跟前面提示对框是一样,都是调show()方法
		dialog.show();
	}
}