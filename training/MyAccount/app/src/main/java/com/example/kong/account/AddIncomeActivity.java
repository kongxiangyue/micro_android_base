package com.example.kong.account;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.kong.account.model.Income;

import java.util.Calendar;

public class AddIncomeActivity extends AppCompatActivity {
    private EditText edTime;
    private EditText edMoney;
    private EditText edRemark;
    private Spinner  spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);
        bindUI();
        init();
    }

    private void bindUI() {
        edTime    = (EditText) findViewById(R.id.edTime);
        edMoney   = (EditText) findViewById(R.id.edMoney);
        edRemark  = (EditText) findViewById(R.id.edRemark);
        spinner   = (Spinner)  findViewById(R.id.spinner);
    }


    private void init() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year   = c.get(Calendar.YEAR);
        int month  = c.get(Calendar.MONTH);
        int date   = c.get(Calendar.DATE);

        edTime.setText(year + "-" + (1 + month) + "-" + date);
        edMoney.setText("0.0");
        edRemark.setText("");
        spinner.setSelection(0);
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave   : {
                handleSave();
            }
            break;
            case R.id.btnCancel : {

            }
            break;
            case R.id.edTime    : {

            }
            break;
            default:
                break;
        }
    }


    private void handleSave() {
        Income income = new Income();
        income.setMoney(Double.valueOf(edMoney.getText().toString()));

    }

}
