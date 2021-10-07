package com.example.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Address";
    public DBHelper(Context context){
        super(context,DB_NAME,null,2);
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
    public void add(AddressVO vo){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",vo.getName());
        values.put("tel",vo.getTel());

        db.insert("Address",null,values);
        db.close();
    }

    public void update(AddressVO vo){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",vo.getName());
        values.put("tel",vo.getTel());

        int count = db.update("address", values,"id=?",new String[]{Integer.toString(vo.getId())});
        Log.i("DB_TABLE", "update: "+count);
        db.close();
    }
    public void delete(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("address", "id=?",new String[]{Integer.toString(id)});
        db.close();
    }
    public List<AddressVO> selectAllAddressVO(){
        ArrayList<AddressVO> list = new ArrayList<AddressVO>();
        String sql = "select * from address";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                list.add(new AddressVO(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
    //전화번호로 검색
    public List<AddressVO> selectAddressVO(String tel) {
        ArrayList<AddressVO> list = new ArrayList<AddressVO>();
        String sql = "select * from address where tel like '%"+tel+"%'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                list.add(new AddressVO(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }




}
