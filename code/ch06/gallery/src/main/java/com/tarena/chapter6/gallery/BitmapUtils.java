package com.tarena.chapter6.gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public class BitmapUtils {
	/**
	 * �����ļ�·������λͼ
	 * 
	 * @param path
	 *            ͼƬ�ļ���·��
	 * @return
	 */
	public static Bitmap getBitmap(String path) {
		return BitmapFactory.decodeFile(path);
	}

	/**
	 * �����ļ�·�� ��ָ������������������λͼ
	 * 
	 * @param path
	 *            ͼƬ�ļ���·��
	 * @param scale
	 *            ��������
	 * @return
	 */
	public static Bitmap getBitmap(String path, int scale) {
		Options opts = new Options();
		// ������������
		opts.inSampleSize = scale;
		return BitmapFactory.decodeFile(path, opts);
	}

	/**
	 * �����ļ�·�� ��ָ����߱����ݺ������������λͼ
	 * 
	 * @param path
	 *            ͼƬ�ļ���·��
	 * @param width
	 *            Ŀ���
	 * @param height
	 *            Ŀ���
	 * @return
	 */
	public static Bitmap getBitmap(String path, int width, int height) {
		Options opts = new Options();
		// �������ԣ�ֻ����ͼƬ�����Ϣ
		opts.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(path, opts);
		// ������������
		int x = opts.outWidth / width;
		int y = opts.outHeight / height;
		int scale = x > y ? x : y;
		return getBitmap(path, scale);
	}
}