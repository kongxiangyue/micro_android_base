package com.tarena.chapter7.sqlitedemo;

import java.util.ArrayList;

import android.content.Context;

public class MusicBiz {
	MusicDao md;
	public MusicBiz(Context context) {
		md = new MusicDao(context);
	}
	public ArrayList<Music> getMusics() {
		return md.getMusics();
	}
}
