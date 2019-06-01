package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ContactsDatabase extends SQLiteOpenHelper {

    public static final String CREATE_CONTACTS = "create table Contacts("
            + "name text primary key autoincrement, "
            + "phone text, "
            + "sex text )";
    private Context mContext;

    public ContactsDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACTS);
       // Toast.makeText(mContext,"Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Contacts");
        onCreate(db);
    }
}
