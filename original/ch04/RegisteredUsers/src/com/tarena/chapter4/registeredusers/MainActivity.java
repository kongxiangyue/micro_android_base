package com.tarena.chapter4.registeredusers;

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
			if (!etUserName.getText().toString().trim().equals("")
					&& !etPassword.getText().toString().trim().equals("")) {
				if (etPassword.getText().toString().trim()
						.equals(etPassAgain.getText().toString().trim())) {
					StringBuilder sb = new StringBuilder("����ע����Ϣ����:\n");
					sb.append("��  ��  ��:")
							.append(etUserName.getText().toString())
							.append('\n');
					sb.append("��        ��:")
							.append(etPassword.getText().toString())
							.append('\n');
					switch (rgSex.getCheckedRadioButtonId()) {
					case R.id.rdoMale:
						sb.append("��        ��: ��\n");
						break;

					case R.id.rdoFemale:
						sb.append("��        ��: Ů\n");
						break;
					}
					sb.append("��        ��: ");
					if (chkEat.isChecked()) {
						sb.append(chkEat.getText()).append(',');
					}
					if (chkPlay.isChecked()) {
						sb.append(chkPlay.getText()).append(',');
					}
					if (chkRead.isChecked()) {
						sb.append(chkRead.getText()).append(',');
					}
					if (chkSleep.isChecked()) {
						sb.append(chkSleep.getText()).append(',');
					}
					sb.deleteCharAt(sb.length() - 1);
					Intent intent = new Intent(MainActivity.this,
							ResultActivity.class);
					intent.putExtra("regInfo", sb.toString());
					startActivity(intent);
					finish();
				} else {
					Toast.makeText(MainActivity.this, "�������벻һ�£�����",
							Toast.LENGTH_SHORT).show();
				}

			} else {
				Toast.makeText(MainActivity.this, "�˺Ż������벻��Ϊ��",
						Toast.LENGTH_SHORT).show();
			}

			break;

		case R.id.btnReset:// ����
			etPassAgain.setText("");
			etPassword.setText("");
			etUserName.setText("");
			rgSex.check(R.id.rdoMale);
			chkEat.setChecked(false);
			chkRead.setChecked(false);
			chkPlay.setChecked(true);
			chkSleep.setChecked(true);
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