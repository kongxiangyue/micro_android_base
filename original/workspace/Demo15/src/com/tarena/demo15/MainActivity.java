package com.tarena.demo15;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	Button mybt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybt = (Button)findViewById(R.id.button1);

    }
	@Override
	public void onClick(View v) {
		switch (key) {
		case value:
			
			break;

		default:
			break;
		}
		
	}
    
//    public void doClick(View view){
//    	switch (view.getId()) {
//		case R.id.button1:
//			
//			break;
//
//		default:
//			break;
//		}
//    }

    
}
