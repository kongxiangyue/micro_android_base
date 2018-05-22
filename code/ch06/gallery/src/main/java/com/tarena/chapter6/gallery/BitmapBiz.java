package com.tarena.chapter6.gallery;

import java.io.File;
import java.util.ArrayList;

public class BitmapBiz {
	public ArrayList<BitmapInfo> getThumbs(File dir) {
		ArrayList<BitmapInfo> infos = null;
		//判断dir是否存在且是一个目录(文件夹)
		if (dir != null && dir.exists() && dir.isDirectory()) {
			//获取指定文件夹中的所有文件名
			String[] fileNames = dir.list();
			//如果存在文件
			if (fileNames != null) {
				//实例化集合
				infos = new ArrayList<BitmapInfo>();
				//循环遍历文件名，设置位图信息
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
