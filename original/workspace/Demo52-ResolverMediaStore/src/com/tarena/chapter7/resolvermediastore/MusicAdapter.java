package com.tarena.chapter7.resolvermediastore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicAdapter extends BaseAdapter {
	LayoutInflater inflater;
	ArrayList<Music> musics;
	// 格式化时间的对象
	SimpleDateFormat formatter;
	public void setMusics(ArrayList<Music> musics) {
		if (musics != null) {
			this.musics = musics;
		} else {
			this.musics = new ArrayList<Music>();
		}
	}
	public MusicAdapter(Context context, ArrayList<Music> musics) {
		this.inflater = LayoutInflater.from(context);
		setMusics(musics);
		this.formatter = new SimpleDateFormat("mm:ss");
	}
	@Override
	public int getCount() {
		return musics.size();
	}
	@Override
	public Object getItem(int position) {
		return musics.get(position);
	}
	@Override
	public long getItemId(int position) {
		return musics.get(position).getId();
	}
	static class ViewHolder {
		private ImageView ivAlbum;
		private TextView tvNmae;
		private TextView tvAlbum;
		private TextView tvSingr;
		private TextView tvDuration;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item, null);
			viewHolder = new ViewHolder();
			viewHolder.ivAlbum = (ImageView) convertView
					.findViewById(R.id.ivAlbum);
			viewHolder.tvNmae = (TextView) convertView
					.findViewById(R.id.tvMusicName);
			viewHolder.tvAlbum = (TextView) convertView
					.findViewById(R.id.tvAlbum);
			viewHolder.tvSingr = (TextView) convertView
					.findViewById(R.id.tvSinger);
			viewHolder.tvDuration = (TextView) convertView
					.findViewById(R.id.tvDuration);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Music music = musics.get(position);
		viewHolder.tvNmae.setText(music.getTitle());
		viewHolder.tvAlbum.setText(music.getAlbum());
		viewHolder.tvSingr.setText(music.getSinger());
		viewHolder.tvDuration.setText(format(music.getDuration()));// music.getDuration()
		// viewHolder.ivAlbum.setImageBitmap(bm);
		// 设置图片
		// 取图片
		Bitmap bm = BitmapFactory.decodeFile(music.getAlbum_path());
		// bm null !null
		if (bm == null) {
			viewHolder.ivAlbum.setImageResource(R.drawable.ic_launcher);
		} else {
			viewHolder.ivAlbum.setImageBitmap(bm);
		}
		return convertView;
	}
	public String format(long duration) {
		return formatter.format(new Date(duration));
	}
}
