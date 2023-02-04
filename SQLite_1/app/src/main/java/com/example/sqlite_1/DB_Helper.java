package com.example.sqlite_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_Helper extends SQLiteOpenHelper {
    private static final String DB_name = "ContactDB";
    private static final int DB_version = 1;
    private static final String Table = "contact";
    private static final String KEY_id = "id";
    private static final String KEY_name = "name";
    private static final String KEY_phone_no = "phone_no";


    public DB_Helper(Context context) {
        super(context, DB_name, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE contacts (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_no TEXT)

        db.execSQL("CREATE TABLE " + Table +
                "(" + KEY_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_name + " TEXT," +KEY_phone_no + " TEXT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Table);
        onCreate(db);
    }
}
