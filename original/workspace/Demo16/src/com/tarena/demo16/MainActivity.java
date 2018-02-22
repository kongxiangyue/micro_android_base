package com.tarena.demo16;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button mybt;
	EditText edittext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mybt = (Button) findViewById(R.id.mybt);
		edittext = (EditText) findViewById(R.id.editText1);
		mybt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String info = edittext.getText().toString();
				Toast.makeText(MainActivity.this, "用户输入的内容：" + info,
						Toast.LENGTH_SHORT).show();
			}
		});
	}

}
