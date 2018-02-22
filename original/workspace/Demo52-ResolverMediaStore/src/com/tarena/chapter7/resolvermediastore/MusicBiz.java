package com.tarena.chapter7.resolvermediastore;

import java.util.ArrayList;

import android.content.Context;

public class MusicBiz {
	MusicDao md;
	public MusicBiz(Context context){
		md = new MusicDao(context);
	}
	public ArrayList<Music> getMusicInfos(){
		return md.search();
	}
}
