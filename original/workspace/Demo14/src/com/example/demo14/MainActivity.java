package com.example.demo14;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView tv;
	TextView tv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.textView1);
		tv2 = (TextView) findViewById(R.id.textView2);
		
		tv.setBackgroundColor(getResources().getColor(
				android.R.color.darker_gray));
		StringBuilder sb = new StringBuilder();
		sb.append("<font color='Red'>达内时代科技集团</font><br>");
		sb.append("<font color='Blue'><big><u> <a href='http://m.tedu.cn'>Show Tarena Home Page</a></u></big></font>");
		tv.setText(Html.fromHtml(sb.toString()));
		tv.setMovementMethod(LinkMovementMethod.getInstance());
		tv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "TextView被点击",
						Toast.LENGTH_LONG).show();
			}
		});
		// -----------------------------------------------------
		String html = "<img src='ic_launcher'/>";
		CharSequence charSequence = Html.fromHtml(html, new ImageGetter() {

			@Override
			public Drawable getDrawable(String source) {
				Drawable drawable = getResources().getDrawable(
						R.drawable.ic_launcher);
				drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
						drawable.getIntrinsicHeight());
				return drawable;
			}
		}, null);
		tv2.setText(charSequence);
		tv2.setMovementMethod(LinkMovementMethod.getInstance());

	}

}
