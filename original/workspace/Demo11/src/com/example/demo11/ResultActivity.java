package com.example.demo11;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity{
	private TextView tvInfo;

	public void setupView() {
		tvInfo = (TextView) findViewById(R.id.tvInfo);
		User user  = (User) getIntent().getSerializableExtra("user");
		if (user!=null) {
			tvInfo.setText("»¶Ó­"+user.getUserName()+"µÇÂ½³É¹¦£¡");
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		setupView();
	}

}
