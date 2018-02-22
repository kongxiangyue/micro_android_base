package com.example.demo40_gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	int[] mImgIds = { R.drawable.img01, R.drawable.img02, R.drawable.img03,
			R.drawable.img04, R.drawable.img05, R.drawable.img06 };
	LayoutInflater infalter;
	public ImageAdapter(Context context){
		this.infalter = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mImgIds.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = infalter.inflate(R.layout.item, null);
		ImageView image = (ImageView) convertView.findViewById(R.id.imageView1);
		image.setImageResource(mImgIds[position]);
		return convertView;
	}

}
