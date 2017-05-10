package redwolf.com.datastoragedemo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * @作者 RedWolf
 * @时间 2017/5/10 18:11
 * @简介 MyOpenHelper.java
 * <p>
 * integer 整型
 * real 浮点型
 * text 文本
 * blob 二进制
 */

public class MyOpenHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "create table Book (" +
            "id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text)";

    //  分类
    public static final String CREATE_CATEGORY = "create table Category (" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)";


    private Context mContext;

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext, "数据库创建成功", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext, "数据库升级成功", Toast.LENGTH_SHORT).show();
    }

    /**
     * @return
     */
    @Override
    public SQLiteDatabase getReadableDatabase() {
        //  创建或者打开一个现有的数据库 (如果数据库已存在则打开,否则 创建)  数据库不可写入的时候 它返回的对象只读,下面的Writable的会异常
        return super.getReadableDatabase();
    }

    /**
     * @return
     */
    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }
}
