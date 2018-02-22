package com.example.demo39_baseadapter;
public class Music {
	int id;
	int musicImg;
	String musicName;
	String musicSinger;
	String musicAlbum;
	String duration;
	public Music(int id, int musicImg, String musicName, String musicSinger,
			String musicAlbum, String duration) {
		this.id = id;
		this.musicImg = musicImg;
		this.musicName = musicName;
		this.musicSinger = musicSinger;
		this.musicAlbum = musicAlbum;
		this.duration = duration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMusicImg() {
		return musicImg;
	}
	public void setMusicImg(int musicImg) {
		this.musicImg = musicImg;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getMusicSinger() {
		return musicSinger;
	}
	public void setMusicSinger(String musicSinger) {
		this.musicSinger = musicSinger;
	}
	public String getMusicAlbum() {
		return musicAlbum;
	}
	public void setMusicAlbum(String musicAlbum) {
		this.musicAlbum = musicAlbum;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
}