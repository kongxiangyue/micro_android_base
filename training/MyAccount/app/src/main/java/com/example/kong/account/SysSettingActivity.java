package com.example.kong.account;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kong.account.dao.PasswordDAO;
import com.example.kong.account.model.Password;

public class SysSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_setting);
    }


    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.btnSetPassword : {
                handleSetPassword();
            }
            break;

            case R.id.btnCancel : {

            }
            break;
            default:
                break;
        }
    }

    private void handleSetPassword() {
        EditText editText = (EditText) findViewById(R.id.editText);
        String str        = editText.getText().toString();
        String toast      = "密码不能为空";
        boolean success   = false;
        do {
            if (true == "".equals(str)) {
                break;
            }

            PasswordDAO passwordDAO = new PasswordDAO(SysSettingActivity.this);
            Password password = new Password();
            password.setPassword(str);
            passwordDAO.add(password);
            toast = "设置成功";
            success = true;

            break;
        } while (false);

        Toast.makeText(SysSettingActivity.this
                , toast
                , Toast.LENGTH_SHORT).show();

        if (success) {
            finish();
        }
    }

}

