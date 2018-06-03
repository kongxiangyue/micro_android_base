package app0.com.ex04personagedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by htx on 2016/2/20.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "splite.db";
    public static final String TABLE_NAME    = "person";
    public static final int VERSION = 1;

    public DBHelper(Context context) {
        // 创建数据库，它在DBManager实例化的时候被调用
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("create table if not exists "
                        + "%s "
                        + "(id integer primary key,"
                        + "name varchar,"
                        + "age integer)"
                , TABLE_NAME);
        // 执行创建表，它在DBManager实例化的时候被调用
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists" + TABLE_NAME);
        this.onCreate(db);
    }
}
