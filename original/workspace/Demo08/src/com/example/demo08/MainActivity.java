package com.example.demo08;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button sendinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendinfo = (Button) findViewById(R.id.sendinfo);
        sendinfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,OtherActivity.class);
//				intent.putExtra("Name", "张三");
//				intent.putExtra("Age", 20);
				
//				Bundle bundle = new Bundle();
//				bundle.putString("Name", "张三");
//				bundle.putInt("Age", 20);
//				intent.putExtras(bundle);
				Cat cat = new Cat();
				intent.putExtra("cat", cat);
				
				
				startActivity(intent);
			}
		});
    }

    
}
