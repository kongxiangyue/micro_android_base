package com.example.lenovo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean checked = checkBox.isChecked();

                String content = checked
                        ? "Yes"
                        : "No";//三目运算

                Toast.makeText(MainActivity.this
                        , content
                        , Toast.LENGTH_SHORT).show();

            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton
                    , boolean ischecked) {

                String content = ischecked
                        ? "Yes"
                        : "No";//三目运算

                Toast.makeText(MainActivity.this
                        , content
                        , Toast.LENGTH_SHORT).show();

            }
        });

    }

}
