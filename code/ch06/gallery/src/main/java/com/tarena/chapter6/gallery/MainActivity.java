package com.tarena.chapter6.gallery;

import java.io.File;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private static final String DIR = "/mnt/sdcard/imgs/";
	private ImageView ivPicture;
	@SuppressWarnings("deprecation")
	private Gallery galThumbs;
	private BitmapBiz biz;
	private BitmapAdapter adapter;
	private void setupView() {
		// 实例化控件
		ivPicture = (ImageView) findViewById(R.id.ivPicture);
		galThumbs = (Gallery) findViewById(R.id.galThumbs);
		// 初始化
		biz = new BitmapBiz();
		adapter = new BitmapAdapter(this, biz.getThumbs(new File(DIR)));
		galThumbs.setAdapter(adapter);
		galThumbs.setSelection(1);
//		galThumbs.getSelectedItem();
//		adapter.getItem(galThumbs.getSelectedItemPosition());
//		galThumbs.getSelectedItemId();
//		galThumbs.getSelectedItemPosition();
	}
	private void addListener() {
		galThumbs.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long itemId) {
				// TODO Auto-generated method stub
				BitmapInfo info = (BitmapInfo) adapter.getItem(position);
				String path = DIR + info.getTitle() + ".jpg";
				Bitmap bm = BitmapUtils.getBitmap(path, 2);
				ivPicture.setImageBitmap(bm);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}

		});
	}
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();
		addListener();
	}
}