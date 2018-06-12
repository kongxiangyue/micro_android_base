package com.example.kong.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kong.account.dao.PasswordDAO;
import com.example.kong.account.model.Password;

public class LoginMainActivity extends AppCompatActivity {
    private Button btnLogin;
    private Button btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin  = (Button) findViewById(R.id.btnLogin);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        
        // 直接退出
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PasswordDAO passwordDAO = new PasswordDAO(LoginMainActivity.this);
                Password password = passwordDAO.find();

                if (null == password) {
                    jumpToMainPanel();
                } else {
                    EditText editText = (EditText) findViewById(R.id.editText);
                    String str        = editText.getText().toString();
                    String strPassword = password.getPassword();

                    if (true == str.equals(strPassword)) {
                        jumpToMainPanel();
                    } else if (true == "".equals(str)) {
                        Toast.makeText(LoginMainActivity.this
                                , "请输入密码"
                                , Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(LoginMainActivity.this
                                , "密码错误"
                                , Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }

    private void jumpToMainPanel() {
        Intent intent = new Intent(LoginMainActivity.this
                , MainPanelActivity.class);

        startActivity(intent);
        finish();

    }
}
