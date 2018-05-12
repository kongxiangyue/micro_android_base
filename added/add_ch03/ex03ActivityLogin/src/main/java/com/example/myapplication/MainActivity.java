package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button   button;
    private EditText editText;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = editText.getText().toString();
                String password = editText2.getText().toString();

                Intent intent = new Intent(MainActivity.this
                        , LonginActivity.class);

                intent.putExtra("username", username);
                intent.putExtra("password", password);
                startActivity(intent);


            }
        });
    }
}
