package com.example.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class MyProvider extends ContentProvider {

    public static final int TABLE_DIR = 0;
    public static final int TABLE_ITEM =1;
    private static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.myapplication.provider","contacts",TABLE_DIR);
        uriMatcher.addURI("com.example.myapplication.provider","contacts/#",TABLE_ITEM);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query( Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (uriMatcher.match(uri)) {
            case TABLE_DIR:
                break;
            case TABLE_ITEM:
                break;
             default:
                 break;
        }
        return null;
    }

    @Override
    public Uri insert( Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int update( Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int delete( Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case TABLE_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.myapplication.provider.contacts";
            case TABLE_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.myapplication.provider.contacts";
            default:
                break;
        }
        return null;
    }
}
