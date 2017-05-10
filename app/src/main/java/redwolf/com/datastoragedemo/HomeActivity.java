package redwolf.com.datastoragedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import redwolf.com.datastoragedemo.R;
import redwolf.com.datastoragedemo.litePal.LitePalActivity;
import redwolf.com.datastoragedemo.sqlite.SQLiteActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.SQLite).setOnClickListener(v->{
            SQLiteActivity.actionStart(HomeActivity.this);
        });
        findViewById(R.id.LitePal).setOnClickListener(v->{
            LitePalActivity.actionStart(HomeActivity.this);

        });
    }
}
