package com.example.edwin.databasehelperutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> columnNames = new ArrayList<>();
        columnNames.add("name");
        columnNames.add("age");
        columnNames.add("grade");
        columnNames.add("sex");
        columnNames.add("score");
        MyOpenHelper helper = new MyOpenHelper(MainActivity.this, "DATABASE.db", "black", 1, columnNames);

        helper.getWritableDatabase();

        System.out.println("数据库创建成功");

    }
}
