package redwolf.com.datastoragedemo.litePal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

import redwolf.com.datastoragedemo.R;
import redwolf.com.datastoragedemo.sqlite.MyOpenHelper;

public class LitePalActivity extends AppCompatActivity {
    private Button btnInsertSQL;
    private Button btnUpdateSQL;
    private Button btnDeleteSQL;
    private Button btnRetrieveSQL;


    public static void actionStart(Context context){
        Intent intent = new Intent(context,LitePalActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initAction();
    }

    private void initData() {

    }

    private void initAction() {
        btnInsertSQL.setOnClickListener(v -> {
            Book book = new Book("Name",111,11.11,"RedWolf","unKnown");
            book.save();

        });
        btnUpdateSQL.setOnClickListener(v -> {
            Book book = new Book();
            book.setPrice(11);
            book.updateAll("name = ? and author = ?","Name","RedWolf");


        });
        btnDeleteSQL.setOnClickListener(v -> {
            DataSupport.deleteAll(Book.class,"price < ?","15");


        });

        btnRetrieveSQL.setOnClickListener(v -> {
            List<Book> bookList = DataSupport.findAll(Book.class);
            List<Book> bookList1 = DataSupport.select("name","author").find(Book.class);
            List<Book> bookList2 = DataSupport.where("name = ?","RedWolf").find(Book.class);
            for (Book book:bookList){
                Log.i("RedWolf", "initAction: "+book.toString());
            }
        });
    }

    private void initView() {
        btnInsertSQL = (Button) findViewById(R.id.btnInsertSQL);
        btnUpdateSQL = (Button) findViewById(R.id.btnUpdateSQL);
        btnDeleteSQL = (Button) findViewById(R.id.btnDeleteSQL);
        btnRetrieveSQL = (Button) findViewById(R.id.btnRetrieveSQL);
    }
}
