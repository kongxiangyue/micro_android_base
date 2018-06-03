package app0.com.ex04personagedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by htx on 2016/2/20.
 */
public class DBManager {//自定义的类,用于封装数据操作
    private DBHelper helper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        //这部分代码在程序刚启动即执行
        // 在最开始实例化的时候，通过DBHelper创建数据库
        helper = new DBHelper(context);
        //因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);
        //所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
        db = helper.getWritableDatabase();
    }

    public void insert(Person person) {
        // insert操作,用于收支记录数据的插入,在"记一笔"那里调用
        db.beginTransaction();  //开始事务
        try {
            ContentValues cv = new ContentValues();
            cv.put("name", person.getName());
            cv.put("age",person.getAge());
            db.insert(DBHelper.TABLE_NAME, "id", cv);
            db.setTransactionSuccessful();  //设置事务成功完成
        }finally {
            db.endTransaction();    //结束事务
        }
    }

    public Person[] getAllPerson()
    {
        Person[] allPerson = new Person[10];// 这是个非常规的做法

        Cursor c = db.rawQuery("select * from "+ DBHelper.TABLE_NAME,null);
        int i = 0;
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Person tmp = new Person();
            tmp.setName(c.getString(1)).setAge(c.getInt(2));
            allPerson[0] = tmp;
            i++;
        }
        c.close();
        return allPerson;
    }



    public void closeDB(){
        db.close();
    }
}
