package com.example.edwin.databasehelperutils;

import android.content.Context;

import java.util.List;

/**
 * Created by chan6 on 2016/03/28.
 *
 * 封装操作数据库的Dao层
 */
public class MyOpenHelperDao {


    private final MyOpenHelper mHelper;

    public MyOpenHelperDao(Context context, String dataBaseName, String tableName, int version, List<String> columnNames){

        mHelper = new MyOpenHelper(context,dataBaseName, tableName, version, columnNames);
    }

}
