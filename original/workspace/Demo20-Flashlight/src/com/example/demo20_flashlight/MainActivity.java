package com.example.demo20_flashlight;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	ImageView bulb;
	ToggleButton mySwitch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bulb = (ImageView) findViewById(R.id.bulb);
		mySwitch = (ToggleButton) findViewById(R.id.mySwitch);
		mySwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					bulb.setImageResource(R.drawable.on);
				}else {
					bulb.setImageResource(R.drawable.off);
				}
			}
		});
	}

}
