package com.example.demo40_gallery;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.Toast;

public class MainActivity extends Activity {
	Gallery gly;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gly = (Gallery) findViewById(R.id.gallery1);
		ImageAdapter adapter = new ImageAdapter(MainActivity.this);
		gly.setAdapter(adapter);
		gly.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this, "您选中了第"+(position+1)+"张图片", 3000).show();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
//		gly.setOnItemClickListener(listener);
	}

}
