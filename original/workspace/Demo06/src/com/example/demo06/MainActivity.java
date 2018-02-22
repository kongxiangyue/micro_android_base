package com.example.demo06;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call = (Button) findViewById(R.id.call);
        call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent();
//				//Action
//				intent.setAction(Intent.ACTION_CALL);
//				//Data
//				Uri uri = Uri.parse("tel://10086");
//				intent.setData(uri);
//				startActivity(intent);
				
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_SENDTO);
				Uri uri = Uri.parse("smsto://10086");
				intent.setData(uri);
				startActivity(intent);
			}
		});
    }


    
}
