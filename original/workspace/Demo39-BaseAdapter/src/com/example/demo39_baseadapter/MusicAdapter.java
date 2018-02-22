package com.example.demo39_baseadapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicAdapter extends BaseAdapter {
	ArrayList<Music> musiclist;
	LayoutInflater infalter;

	public MusicAdapter(Context context, ArrayList<Music> musiclist) {
		this.infalter = LayoutInflater.from(context);
		this.musiclist = musiclist;
	}

	// 返回值决定了ListView的总数据条数 返回值控制getView方法的回调次数
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return musiclist.size();
	}

	// listview.getitematposition adapter.getitem
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return musiclist.get(position);
	}

	// listview.getitemidatposition adapter.getitemid
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return musiclist.get(position).getId();
	}

	// 返回item对象
	// int position item的索引值
	// View convertView 表示返回的item View对象
	// ViewGroup parent listview
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = infalter.inflate(R.layout.item, null);
			holder = new ViewHolder();
			holder.img = (ImageView) convertView.findViewById(R.id.img);
			holder.musicName = (TextView) convertView
					.findViewById(R.id.musicName);
			holder.musicAlbum = (TextView) convertView
					.findViewById(R.id.albumName);
			holder.musicSinger = (TextView) convertView
					.findViewById(R.id.singer);
			holder.musicDuration = (TextView) convertView
					.findViewById(R.id.duration);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		Music music = musiclist.get(position);
		holder.img.setImageResource(R.drawable.ic_launcher);
		holder.musicName.setText(music.getMusicName());
		holder.musicAlbum.setText(music.getMusicAlbum());
		holder.musicSinger.setText(music.getMusicSinger());
		holder.musicDuration.setText(music.getDuration());
		return convertView;
	}

	static class ViewHolder {

		ImageView img;
		TextView musicName;
		TextView musicAlbum;
		TextView musicSinger;
		TextView musicDuration;
	}
}
