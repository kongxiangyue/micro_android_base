package com.example.demo46_simplecursoradapter;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String sql = "";
//      Cursor c = db.rqwquery(sql);
      String from[] = {"","","",""};
      int to [] = {};
//        context �����Ķ���
//        layout item�����ļ�
//        c		�α�
//        from ��ѯ�����ֶ�����ɵ�����
//        to	�����е����пؼ�id��ɵ�����
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(context, layout, c, from, to);
//        ����Ҫ������� "_id"
    }


    
}
