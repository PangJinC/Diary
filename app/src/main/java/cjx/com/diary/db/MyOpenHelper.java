package cjx.com.diary.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

import cjx.com.diary.mode.diary.DaoMaster;

/**
 * description: GreenDao帮助类
 * author: bear .
 * Created date:  2017/5/17.
 */
public class MyOpenHelper extends DaoMaster.DevOpenHelper {


    public MyOpenHelper(Context context, String name) {
        super(context, name);
    }

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {}
}
