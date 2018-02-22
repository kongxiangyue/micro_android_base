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
//        context 上下文对象
//        layout item布局文件
//        c		游标
//        from 查询到的字段名组成的数组
//        to	布局中的所有控件id组成的数组
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(context, layout, c, from, to);
//        主键要求务必是 "_id"
    }


    
}
