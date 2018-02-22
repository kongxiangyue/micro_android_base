package com.example.contentresolver;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ContentResolver cr = getContentResolver();
//        cr.insert(url, values);
//        cr.delete(url, where, selectionArgs);
//        cr.update(uri, values, where, selectionArgs);
//        cr.query(uri, projection, selection, selectionArgs, sortOrder);
    }

//    content://media/internal/images
//    content://contacts/people
//    content://contacts/people/45
}
