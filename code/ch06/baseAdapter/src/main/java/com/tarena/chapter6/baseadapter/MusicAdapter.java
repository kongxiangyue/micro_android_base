package com.tarena.chapter6.baseadapter;
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
	LayoutInflater inflater;
	/**
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
		// 加载填充一个布局文件
		convertView = inflater.inflate(R.layout.item, null);
		ImageView img = (ImageView) convertView.findViewById(R.id.img);
		TextView musicName = (TextView) convertView
				.findViewById(R.id.musicName);
		TextView musicAlbum = (TextView) convertView
				.findViewById(R.id.albumName);
		TextView musicSinger = (TextView) convertView.findViewById(R.id.singer);
		TextView musicDuration = (TextView) convertView
				.findViewById(R.id.duration);
		Music music = musiclist.get(position);
		img.setImageResource(music.getMusicImg());
		musicName.setText(music.getMusicName());
		musicAlbum.setText(music.getMusicAlbum());
		musicSinger.setText(music.getMusicSinger());
		musicDuration.setText(music.getDuration());
		return convertView;
	}
}