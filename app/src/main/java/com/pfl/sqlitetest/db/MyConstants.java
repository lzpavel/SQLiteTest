package com.pfl.sqlitetest.db;

public class MyConstants {
    public static final String TABLE_NAME = "my_table";
    public static final String ID = "_id";
    public static final String TEXT = "text";
    public static final String DB_NAME = "my_db.db";
    public static final int DB_VERSION = 1;

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    ID + " INTEGER PRIMARY KEY," +
                    TEXT + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
