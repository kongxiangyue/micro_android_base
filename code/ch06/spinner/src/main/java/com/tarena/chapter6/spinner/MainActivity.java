package com.tarena.chapter6.spinner;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textLevelContent;
	private Spinner myspinner;
	private ArrayAdapter<String> spAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textLevelContent = (TextView) findViewById(R.id.textLevelContent);
		myspinner = (Spinner) findViewById(R.id.spinnerlevel);

		List<String> dataList = new ArrayList<String>();
		dataList.add("������");
		dataList.add("����");
		dataList.add("���г�");

		spAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, dataList);
		spAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		myspinner.setAdapter(spAdapter);

		/* ������Spinner���û�ѡ���¼� */
		myspinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				String selectedStr = (String) spAdapter.getItem(position);
				textLevelContent.setText("��ǰ��ѡ��ĳ��з�ʽ��" + selectedStr);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				/* δѡ���κ���Ĵ��� */
			}
		});
	}
}