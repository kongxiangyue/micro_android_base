package com.tarena.chapter5.timepickerdialogdemo;

import java.util.Calendar;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TimePicker tpSet;
	private TimePickerDialog dialog;

	private void setupView() {
		tpSet = (TimePicker) findViewById(R.id.tpSet);
		// ≥ı ºªØ
		tpSet.setCurrentHour(11);
		tpSet.setCurrentMinute(40);
		tpSet.setIs24HourView(false);
		tpSet.setOnTimeChangedListener(new OnTimeChangedListener() {

			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, hourOfDay + ":" + minute,
						3000).show();
			}
		});
	}

	public void doClick(View v) {
		Calendar c = Calendar.getInstance();
		// int hour = c.get(Calendar.HOUR);
		// int min = c.get(Calendar.MINUTE);

		dialog.show();
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();

		dialog = new TimePickerDialog(this, new OnTimeSetListener() {

			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, hourOfDay + ":" + minute,
						3000).show();
			}
		}, 11, 44, true);
	}
}
