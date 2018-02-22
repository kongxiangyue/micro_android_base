package com.example.demo23_alertdialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ProgressDialog pd = new ProgressDialog(MainActivity.this);
		pd.setTitle("进度条对话框的标题");
		pd.setIcon(R.drawable.ic_launcher);
		pd.setMax(100);
		pd.setMessage("文件已下载");
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd.setCancelable(false);
		pd.show();
	}

}
