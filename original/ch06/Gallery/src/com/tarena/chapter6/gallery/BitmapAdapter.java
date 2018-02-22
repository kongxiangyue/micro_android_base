package com.tarena.chapter6.gallery;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BitmapAdapter extends BaseAdapter {
	private ArrayList<BitmapInfo> infos;
	private LayoutInflater inflater;
	public BitmapAdapter(Context context, ArrayList<BitmapInfo> infos) {
		if (infos != null)
			this.infos = infos;
		else
			this.infos = new ArrayList<BitmapInfo>();
		this.inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return infos.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return infos.get(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// ���غ͸���item��ͼ
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item, null);
			holder = new ViewHolder();
			holder.ivThumb = (ImageView) convertView.findViewById(R.id.ivThumb);
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		// ��ȡָ��λ�õ�����
		BitmapInfo info = infos.get(position);
		// ����д�뵽����
		holder.ivThumb.setImageBitmap(info.getBitmap());
		holder.tvTitle.setText(info.getTitle());
		// ����item��ͼ
		return convertView;
	}
	static class ViewHolder {
		ImageView ivThumb;
		TextView tvTitle;
	}
}