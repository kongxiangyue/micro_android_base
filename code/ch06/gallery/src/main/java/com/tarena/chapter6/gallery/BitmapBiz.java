package com.tarena.chapter6.gallery;

import java.io.File;
import java.util.ArrayList;

public class BitmapBiz {
	public ArrayList<BitmapInfo> getThumbs(File dir) {
		ArrayList<BitmapInfo> infos = null;
		//�ж�dir�Ƿ��������һ��Ŀ¼(�ļ���)
		if (dir != null && dir.exists() && dir.isDirectory()) {
			//��ȡָ���ļ����е������ļ���
			String[] fileNames = dir.list();
			//��������ļ�
			if (fileNames != null) {
				//ʵ��������
				infos = new ArrayList<BitmapInfo>();
				//ѭ�������ļ���������λͼ��Ϣ
				for (String fileName : fileNames) {
					BitmapInfo info = new BitmapInfo();
					info.setTitle(fileName.substring(0, fileName
							.lastIndexOf(".")));
					info.setBitmap(BitmapUtils.getBitmap(
							new File(dir, fileName).getAbsolutePath(), 80, 80));

					infos.add(info);
				}
			}
		}
		return infos;
	}
}
