package com.tarena.chapter6.gallery;
import android.graphics.Bitmap;
public class BitmapInfo {
	private Bitmap bitmap;
	private String title;
	public Bitmap getBitmap() {
		return bitmap;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}