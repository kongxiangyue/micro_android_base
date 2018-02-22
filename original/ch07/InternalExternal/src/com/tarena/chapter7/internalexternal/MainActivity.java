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
			/* ���Զ�д�ⲿ�洢���� */
			exStorageReadable = exStorageWriteable = true;
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			/* ֻ�ܶ�������д */
			exStorageReadable = true;
			exStorageWriteable = false;
		} else {
			/*
			 * ���ܶ�д���ⲿ�洢���ʿ��ܴ�����������������һһ�ֲ�����״̬ ֮�У������������õ�״̬
			 */
			exStorageReadable = exStorageWriteable = false;
		}

	}
	public void createExPubStoragePicture() {
		/*
		 * �õ�ָ���ⲿ���ô洢���ļ�����
		 * ����ָ��ΪDIRECTORY_PICTURES
		 * ��ר�Ŵ��ͼƬ
		 */
		File path = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		File file = new File(path, "DemoPicture.jpg");

		try {
			// ��֤�ⲿ���ô洢����
			path.mkdirs();
			// ʹ���ֽ�����ȡͼƬ���ݣ�Ȼ��д���ⲿ�����ļ�
			InputStream is = getResources()
					.openRawResource(R.drawable.ic_launcher);
			OutputStream os = new FileOutputStream(file);
			byte[] data = new byte[is.available()];
			is.read(data);
			os.write(data);
			is.close();
			os.close();

			// ֪ͨý��ɨ����������һ�ſ��õ�ͼƬ
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
			// δ�ɹ�����Ϊ�ⲿ�洢���ܶ�ʧ��
			Log.w("ExternalStorage", "Error writing "
					+ file, e);
		}
	}

	// ɾ���ļ�
	public void deleteExPubStoragePicture() {
		File path = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		File file = new File(path, "DemoPicture.jpg");
		file.delete();
	}

	// �ж��ļ��Ƿ����
	public boolean hasExPubStoragePicture() {
		File path = Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		File file = new File(path, "DemoPicture.jpg");
		return file.exists();
	}

}
