package com.tarena.chapter6.baseadapter2;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicAdapter extends BaseAdapter {
	ArrayList<Music> musiclist;
	LayoutInflater inflater;

	/**
	 * 
	 * @param context
	 *            上下文对象
	 * @param musiclist
	 *            音乐列表
	 */
	public MusicAdapter(Context context, ArrayList<Music> musiclist) {
		this.inflater = LayoutInflater.from(context);
		this.musiclist = musiclist;
	}

	// 该方法的返回值决定ListView的条数 也意味着决定着getView方法的回调次数
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return musiclist.size();
	}

	// 一般用不到 但是此处最好给予正确的返回值 否则在 listview.getItemAtPosition(position)
	// 以及adapter.getItem(position)的时候将无法得到对象
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return musiclist.get(position);
	}

	// 一般用不到 但是此处最好给予正确的返回值 否则在 listview.getItemIdAtPosition(position)
	// 以及adapter.getItemId(position)的时候将无法得到参数
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return musiclist.get(position).getId();
	}

	@Override
	/*
	 * int position 对应的索引位置 从0开始 View convertView 对应的一条item对象 ViewGroup parent
	 * item的父容器即ListView return convertView 返回值 表示一条item对象
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		// 加载填充一个布局文件
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item, null);
			Log.i("info", "加载item布局文件");
			holder = new ViewHolder();
			holder.img = (ImageView) convertView.findViewById(R.id.img);
			holder.musicName = (TextView) convertView.findViewById(R.id.musicName);
			holder.musicAlbum = (TextView) convertView.findViewById(R.id.albumName);
			holder.musicSinger = (TextView) convertView.findViewById(R.id.singer);
			holder.musicDuration = (TextView) convertView.findViewById(R.id.duration);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Music music = musiclist.get(position);
		holder.img.setImageResource(music.getMusicImg());
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

