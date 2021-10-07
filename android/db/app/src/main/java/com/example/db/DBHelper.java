package com.example.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Address";
    public DBHelper(Context context){
        super(context,DB_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Cursor cursor = sqLiteDatabase.
                rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name = 'ADDRESS'",null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            Log.i("DB_TABLE", "onCreate: 테이블이 이미 존재합니다.");
        }else{
            Log.i("DB_TABLE", "onCreate: 해당 테이블 생성");
            String sql = "create table address(id integer primary key autoincrement, name text, tel text)";
            sqLiteDatabase.execSQL(sql);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "drop table if exists address";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
