package com.example.edwin.databasehelperutils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by chan6 on 2016/03/28.
 * <p/>
 * 数据库的封装类
 */
public class MyOpenHelper extends SQLiteOpenHelper {

    //创建的数据库名
    private String dataBaseName;
    //创建的表名
    private String tableName;
    //创建表时添加的多个列
    private List<String> columnNames;
    //查询数据库的sql语句
    private String sql = "";

    /**
     * 自定义构造函数   将相应的参数出入  创建数据库文件
     *
     * @param context
     * @param dataBaseName 数据库名
     * @param tableName    当前要创建的表名
     * @param version      版本号
     * @param columnNames  需要创建的列的集合
     */
    public MyOpenHelper(Context context, String dataBaseName, String tableName, int version, List<String> columnNames) {
        super(context, dataBaseName, null, version);
        this.tableName = tableName;
        this.columnNames = columnNames;
        this.dataBaseName = dataBaseName;
    }

    /**
     * 遍历列名的集合  拼接sql语句  创建表
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        sql = "create table " + tableName + "(_id Integer primary key autoincrement,";
        for (int i = 0; i < columnNames.size(); i++) {
            if (i < columnNames.size() - 1) {
                sql += columnNames.get(i) + " varchar,";
            } else {
                sql += columnNames.get(i) + " varchar);";
            }
        }
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table " + dataBaseName);

        onCreate(db);
    }
}
