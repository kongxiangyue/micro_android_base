package com.example.demo21registeredusers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etUserName, etPassword, etPassAgain;
	private RadioGroup rgSex;
	private CheckBox chkSleep, chkPlay, chkRead, chkEat;

	private void setupView() {
		etUserName = (EditText) findViewById(R.id.etUserName);
		etPassAgain = (EditText) findViewById(R.id.etPassAgain);
		etPassword = (EditText) findViewById(R.id.etPassword);
		rgSex = (RadioGroup) findViewById(R.id.rgSex);
		chkEat = (CheckBox) findViewById(R.id.chkEat);
		chkPlay = (CheckBox) findViewById(R.id.chkPlayGame);
		chkRead = (CheckBox) findViewById(R.id.chkRad);
		chkSleep = (CheckBox) findViewById(R.id.chkSleep);
	}

	public void doClick(View view) {
		switch (view.getId()) {
		case R.id.btnReg:// ע��
			if (!etUserName.getText().toString().equals("")
					&& !etPassword.getText().toString().equals("")) {
				if (etPassword.getText().toString()
						.equals(etPassword.getText().toString())) {
					StringBuilder strb = new StringBuilder("����ע����Ϣ���£�\n");
					strb.append("�û�����").append(etUserName.getText().toString()).append("\n");
					strb.append("���룺").append(etPassword.getText().toString()).append("\n");
					switch (rgSex.getCheckedRadioButtonId()) {
					case R.id.rdoMale:
						strb.append("��  ����\n");
						break;

					case R.id.rdoFemale:
						strb.append("��  ��Ů\n");
						break;
					}
					strb.append("��  �ã�\n");
					if (chkEat.isChecked()) {
						strb.append(chkEat.getText()+",");
					}
					if (chkSleep.isChecked()) {
						strb.append(chkSleep.getText()+",");
					}
					if (chkRead.isChecked()) {
						strb.append(chkRead.getText()+",");
					}
					if (chkPlay.isChecked()) {
						strb.append(chkPlay.getText()+",");
					}
					strb.deleteCharAt(strb.length()-1);
					Intent intent = new Intent(MainActivity.this,ResultActivity.class);
					intent.putExtra("regInfo", strb.toString());
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(MainActivity.this, "�������벻һ��",
							Toast.LENGTH_SHORT).show();
				}
			} else {
				Toast.makeText(MainActivity.this, "�˺Ż������벻��Ϊ��",
						Toast.LENGTH_SHORT).show();

			}

			break;

		case R.id.btnReset:// ����

			break;
		}
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();
	}

}
