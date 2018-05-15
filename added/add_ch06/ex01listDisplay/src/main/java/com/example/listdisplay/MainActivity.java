package com.example.listdisplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Array of strings...
    String[] mobileArray = {"Android"
            , "IPhone"
            , "WindowsMobile"
            , "Blackberry"
            , "WebOS"
            , "Ubuntu"
            , "Windows7"
            , "Max OS X"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter adapter = new ArrayAdapter<String>(this
                , R.layout.activity_listview
                , mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent
                    , View view
                    , int position
                    , long id) {

                Toast.makeText(MainActivity.this
                        , mobileArray[position]
                        , Toast.LENGTH_SHORT).show();

            }
        });
    }
}
