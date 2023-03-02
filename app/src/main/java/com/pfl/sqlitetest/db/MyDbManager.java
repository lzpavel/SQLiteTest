package com.pfl.sqlitetest.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class MyDbManager {
    private Context context;
    private MyDbHelper helper;
    private SQLiteDatabase db;

    public MyDbManager(Context context) {
        this.context = context;
        helper = new MyDbHelper(context);
    }
    public void openDb() {
        db = helper.getWritableDatabase();
    }
    public void insertToDb(String title) {
        ContentValues cv = new ContentValues();
        cv.put(MyConstants.TEXT, title);
        db.insert(MyConstants.TABLE_NAME, null, cv);
    }
    public List<String> readFromDb() {
        List<String> list = new ArrayList<>();
        Cursor cursor = db.query(MyConstants.TABLE_NAME,
                null, null, null,null, null, null);
        while (cursor.moveToNext()) {
            list.add(cursor.getString(cursor.getColumnIndexOrThrow(MyConstants.TEXT)));
        }
        cursor.close();
        return list;
    }
}
