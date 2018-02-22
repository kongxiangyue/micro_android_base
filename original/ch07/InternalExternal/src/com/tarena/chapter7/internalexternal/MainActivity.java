package com.tarena.chapter7.internalexternal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			String fileName = "HelloFile";
			String str = "Hello world!";
			FileOutputStream fos = openFileOutput(fileName,
					Context.MODE_PRIVATE);
			fos.write(str.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean exStorageReadable = false;
		boolean exStorageWriteable = false;
		String state = Environment.getExternalStorageState();

		if (Environment.MEDIA_MOUNTED.equals(state)) {
			/* 可以读写外部存储介质 */
			exStorageReadable = exStorageWriteable = true;
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			/* 只能读，不能写 */
			exStorageReadable = true;
			exStorageWriteable = false;
		} else {
			/*
			 * 不能读写，外部存储介质可能处于上文中所讲的任一一种不可用状态 之中，或其他不可用的状态
			 */
			exStorageReadable = exStorageWriteable = false;
		}

	}
	public void createExPubStoragePicture() {
		/*
		 * 得到指向外部公用存储的文件对象，
		 * 将其指定为DIRECTORY_PICTURES
		 * ，专门存放图片
		 */
		File path = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		File file = new File(path, "DemoPicture.jpg");

		try {
			// 保证外部公用存储存在
			path.mkdirs();
			// 使用字节流读取图片数据，然后写入外部公用文件
			InputStream is = getResources()
					.openRawResource(R.drawable.ic_launcher);
			OutputStream os = new FileOutputStream(file);
			byte[] data = new byte[is.available()];
			is.read(data);
			os.write(data);
			is.close();
			os.close();

			// 通知媒体扫描器新增了一张可用的图片
			MediaScannerConnection
					.scanFile(
							this,
							new String[] { file.toString() },
							null,
							new MediaScannerConnection.OnScanCompletedListener() {
								public void onScanCompleted(
										String path, Uri uri) {
									Log.i("ExternalStorage",
											"Scanned "
													+ path
													+ ":");
									Log.i("ExternalStorage",
											"-> uri=" + uri);
								}
							});
		} catch (IOException e) {
			// 未成功，因为外部存储可能丢失了
			Log.w("ExternalStorage", "Error writing "
					+ file, e);
		}
	}

	// 删除文件
	public void deleteExPubStoragePicture() {
		File path = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		File file = new File(path, "DemoPicture.jpg");
		file.delete();
	}

	// 判断文件是否存在
	public boolean hasExPubStoragePicture() {
		File path = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		File file = new File(path, "DemoPicture.jpg");
		return file.exists();
	}

}
