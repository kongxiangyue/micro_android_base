package com.example.kong.account;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

// 登录成功后主界面
public class MainPanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_panel);

    }


    void clickBtn(View v) {
        switch (v.getId()) {
            case R.id.btn_add_income   : {
                jumpAcitivty(AddIncomeActivity.class);
            }
            break;
            case R.id.btn_add_expense  : {
                jumpAcitivty(AddExpenseActivity.class);
            }
            break;
            case R.id.btn_income_info  : {
                jumpAcitivty(IncomeInfoActivity.class);
            }
            break;
            case R.id.btn_expense_info : {
                jumpAcitivty(ExpenseInfoActivity.class);
            }
            break;
            case R.id.btn_note         : {
                jumpAcitivty(NoteActivity.class);
            }
            break;
            case R.id.btn_show_info    : {
                jumpAcitivty(ShowInfoActivity.class);
            }
            break;
            case R.id.btn_syssetting   : {
                jumpAcitivty(SysSettingActivity.class);
            }
            break;
            case R.id.btn_exit         : {
                finish();
            }
            break;
            default: break;
        }
    }

    private void jumpAcitivty(Class activity) {
        Intent intent = new Intent(MainPanelActivity.this
                , activity);

        startActivity(intent);

    }



}
