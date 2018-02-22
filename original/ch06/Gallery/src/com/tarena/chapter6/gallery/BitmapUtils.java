package com.tarena.chapter6.gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public class BitmapUtils {
	/**
	 * 根据文件路径加载位图
	 * 
	 * @param path
	 *            图片文件的路径
	 * @return
	 */
	public static Bitmap getBitmap(String path) {
		return BitmapFactory.decodeFile(path);
	}

	/**
	 * 根据文件路径 以指定的收缩比例，加载位图
	 * 
	 * @param path
	 *            图片文件的路径
	 * @param scale
	 *            收缩比例
	 * @return
	 */
	public static Bitmap getBitmap(String path, int scale) {
		Options opts = new Options();
		// 设置收缩比例
		opts.inSampleSize = scale;
		return BitmapFactory.decodeFile(path, opts);
	}

	/**
	 * 根据文件路径 以指定宽高保持纵横比收缩，加载位图
	 * 
	 * @param path
	 *            图片文件的路径
	 * @param width
	 *            目标宽
	 * @param height
	 *            目标高
	 * @return
	 */
	public static Bitmap getBitmap(String path, int width, int height) {
		Options opts = new Options();
		// 设置属性，只加载图片宽高信息
		opts.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(path, opts);
		// 计算收缩比例
		int x = opts.outWidth / width;
		int y = opts.outHeight / height;
		int scale = x > y ? x : y;
		return getBitmap(path, scale);
	}
}