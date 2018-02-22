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
	 *            �����Ķ���
	 * @param musiclist
	 *            �����б�
	 */
	public MusicAdapter(Context context, ArrayList<Music> musiclist) {
		this.inflater = LayoutInflater.from(context);
		this.musiclist = musiclist;
	}
	// �÷����ķ���ֵ����ListView������ Ҳ��ζ�ž�����getView�����Ļص�����
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return musiclist.size();
	}
	// һ���ò��� ���Ǵ˴���ø�����ȷ�ķ���ֵ ������ listview.getItemAtPosition(position)
	// �Լ�adapter.getItem(position)��ʱ���޷��õ�����
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return musiclist.get(position);
	}
	// һ���ò��� ���Ǵ˴���ø�����ȷ�ķ���ֵ ������ listview.getItemIdAtPosition(position)
	// �Լ�adapter.getItemId(position)��ʱ���޷��õ�����
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return musiclist.get(position).getId();
	}
	@Override
	/*
	 * int position ��Ӧ������λ�� ��0��ʼ View convertView ��Ӧ��һ��item���� ViewGroup parent
	 * item�ĸ�������ListView return convertView ����ֵ ��ʾһ��item����
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		// �������һ�������ļ�
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