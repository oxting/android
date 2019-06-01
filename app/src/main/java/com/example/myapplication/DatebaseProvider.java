package com.example.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class DatebaseProvider extends ContentProvider {

    public static final int CONTACTS_DIR = 0;
    public static final int CONTACTS_ITEM =1;
    public static final String AUTHORITY = "com.example.myapplication.provider";
    private static UriMatcher uriMatcher;
    private ContactsDatabase dbHelper;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"contacts",CONTACTS_DIR);
        uriMatcher.addURI(AUTHORITY,"contacts/#",CONTACTS_ITEM);
    }

    @Override
    public boolean onCreate() {
        dbHelper = new ContactsDatabase(getContext(),"Contact",null,2);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (uriMatcher.match(uri)){
            case CONTACTS_DIR:
                cursor = db.query("Contacts",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case CONTACTS_ITEM:
                String contactId = uri.getPathSegments().get(1);
                cursor = db.query("Contacts",projection,"id=?",new String[] {contactId},null,null,sortOrder);
                break;
            default:
                break;
        }
        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case CONTACTS_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.myapplication.provider.contacts";
            case CONTACTS_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.myapplication.provider.contacts";
            default:
                break;
        }
        return null;
    }


}


