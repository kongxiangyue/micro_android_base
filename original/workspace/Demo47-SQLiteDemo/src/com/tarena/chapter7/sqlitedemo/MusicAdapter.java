package com.tarena.chapter7.sqlitedemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MusicAdapter extends BaseAdapter {
	ArrayList<Music> musics;
	LayoutInflater inflater;
	public MusicAdapter(Context context, ArrayList<Music> musics) {
		if (musics != null) {
			this.musics = musics;
		} else {
			this.musics = new ArrayList<Music>();
		}
		this.inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return musics.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return musics.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return musics.get(position).getId();
	}
	static class ViewHolder {
		TextView tvDuration;
		TextView tvName;
		TextView tvSinger;
		TextView tvAlbum;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item, null);
			holder = new ViewHolder();
			holder.tvName = (TextView) convertView
					.findViewById(R.id.tvMusicName);
			holder.tvAlbum = (TextView) convertView.findViewById(R.id.tvAlbum);
			holder.tvSinger = (TextView) convertView
					.findViewById(R.id.tvSinger);
			holder.tvDuration = (TextView) convertView
					.findViewById(R.id.tvDuration);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Music music = musics.get(position);
		holder.tvName.setText(music.getName());
		holder.tvAlbum.setText(music.getAlbum());
		holder.tvSinger.setText(music.getSinger());
		holder.tvDuration.setText(formatTime(music.getDuration()));
		return convertView;
	}
	public String formatTime(long time) {
		SimpleDateFormat formator = new SimpleDateFormat("mm:ss");
		return formator.format(new Date(time));
	}
	public String format(long time) {
		long sec = time / 1000 % 60;
		long min = time / 1000 / 60;
		return min + ":" + sec;
	}
}
