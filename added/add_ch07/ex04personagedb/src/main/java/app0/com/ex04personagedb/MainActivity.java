package app0.com.ex04personagedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


//tom 12
// UI -->  DB相关对象---> 数据库文件

// 界面相关 xml UI绑定 点击响应
// Person     数据封装  行-->对象
// DBHelper   用于新建、管理数据库
// DBManager  用操作数据（插入、查询）

public class MainActivity extends AppCompatActivity {
    EditText edName,edAge;
    TextView tvInfo;
    Button btnCommit;
    Button btnGet;
    DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindUI();
        dbManager = new DBManager(MainActivity.this);

        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                person.setName(edName.getText().toString())
                        .setAge(Integer.parseInt(edAge.getText().toString()));
                dbManager.insert(person);

            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person[] allPerson = dbManager.getAllPerson();
                tvInfo.setText(allPerson[0].getName() + "-" + allPerson[0].getAge());
            }
        });

    }

    private void bindUI() {
        // UI绑定
        edName     = (EditText)findViewById(R.id.edname);
        edAge      = (EditText)findViewById(R.id.edage);
        btnCommit  = (Button)findViewById(R.id.btncommit);
        btnGet     = (Button)findViewById(R.id.button);
        tvInfo     = (TextView)findViewById(R.id.tvinfo);
    }
}
