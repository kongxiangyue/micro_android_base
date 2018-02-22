package com.tarena.chapter4.seekbardemo;

import com.tarena.chapter4.seekbardemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity implements
		SeekBar.OnSeekBarChangeListener {
	private static final String TAG = "TARENA";

	// �롰ϵͳĬ��SeekBar����Ӧ��TextView
	private TextView mTvDef;
	// �롰�Զ���SeekBar����Ӧ��TextView
	private TextView mTvSelf;
	// ��ϵͳĬ��SeekBar��
	private SeekBar mSeekBarDef;
	// ���Զ���SeekBar��
	private SeekBar mSeekBarSelf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// �롰ϵͳĬ��SeekBar����Ӧ��TextView
		mTvDef = (TextView) findViewById(R.id.tv_def);
		// ��ϵͳĬ��SeekBar��
		mSeekBarDef = (SeekBar) findViewById(R.id.seekbar_def);
		mSeekBarDef.setOnSeekBarChangeListener(this);

		// �롰�Զ���SeekBar����Ӧ��TextView
		mTvSelf = (TextView) findViewById(R.id.tv_self);
		// ���Զ���SeekBar��
		mSeekBarSelf = (SeekBar) findViewById(R.id.seekbar_self);
		mSeekBarSelf.setOnSeekBarChangeListener(this);
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {

	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		Log.d(TAG, "seekid:" + seekBar.getId() + ", progess" + progress);
		switch (seekBar.getId()) {
		case R.id.seekbar_def: {
			// ���á���ϵͳĬ��SeekBar��Ӧ��TextView����ֵ
			mTvDef.setText("Ĭ��SeekBar" + " : "
					+ String.valueOf(seekBar.getProgress()));
			break;
		}
		case R.id.seekbar_self: {
			// ���á����Զ���SeekBar��Ӧ��TextView����ֵ
			mTvSelf.setText("�Զ���SeekBar" + " : "
					+ String.valueOf(seekBar.getProgress()));
			break;
		}
		default:
			break;
		}
	}
}