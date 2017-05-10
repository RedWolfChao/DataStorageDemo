package redwolf.com.datastoragedemo.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import redwolf.com.datastoragedemo.R;

public class MainActivity extends AppCompatActivity {
    private Button btnInsertSQL;
    private Button btnUpdateSQL;
    private Button btnDeleteSQL;
    private Button btnRetrieveSQL;

    private MyOpenHelper mMyOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initAction();
    }

    private void initData() {
        mMyOpenHelper = new MyOpenHelper(this, "Book.db", null, 3);
    }

    private void initAction() {
        btnInsertSQL.setOnClickListener(v -> {
            SQLiteDatabase db = mMyOpenHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put("name", "Name_1");
            values.put("author", "AUTHOR_1");
            values.put("pages", 333);
            values.put("price", 998.998);
            db.insert("Book", null, values);
            Toast.makeText(this, "无奈 数据添加完了", Toast.LENGTH_SHORT).show();
        });
        btnUpdateSQL.setOnClickListener(v -> {
            SQLiteDatabase db = mMyOpenHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("price", 123);
            db.update("Book", values, "name = ?", new String[]{"Name_1"});
            Toast.makeText(this, "无奈 数据更新完了", Toast.LENGTH_SHORT).show();
        });
        btnDeleteSQL.setOnClickListener(v -> {
            SQLiteDatabase db = mMyOpenHelper.getWritableDatabase();
            db.delete("Book", "pages > ?", new String[]{"500"});
            Toast.makeText(this, "无奈 数据删除完了", Toast.LENGTH_SHORT).show();

        });

        btnRetrieveSQL.setOnClickListener(v -> {
            SQLiteDatabase db = mMyOpenHelper.getWritableDatabase();
            /**
             * table --> from table_name            指定查询的表名
             * columns --> select column1,column2   指定查询的列名
             * selection --> where column = value   指定where约束条件
             * selectionArgs --> -                  为where中的占位符提供具体的值
             * groupBy --> group by column          指定需要group By 的列
             * having --> having column = value     对group by的结果进行进一步约束
             * orderBy --> order by column1,column2 指定查询结果的排序方式
             */
            //  查询Book表中的所有数据
            Cursor cursor = db.query("Book", null, null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    //  遍历Cursor表
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String author = cursor.getString(cursor.getColumnIndex("author"));
                    int price = cursor.getInt(cursor.getColumnIndex("price"));
                    double pages = cursor.getDouble(cursor.getColumnIndex("pages"));
                    Log.i("RedWolf", "cursor :name  " + name + " author " + author + " price " + price + " pages " + pages);
                } while (cursor.moveToNext());
            }
            cursor.close();

        });
    }

    private void initView() {
        btnInsertSQL = (Button) findViewById(R.id.btnInsertSQL);
        btnUpdateSQL = (Button) findViewById(R.id.btnUpdateSQL);
        btnDeleteSQL = (Button) findViewById(R.id.btnDeleteSQL);
        btnRetrieveSQL = (Button) findViewById(R.id.btnRetrieveSQL);
    }
}
