package com.samurais.codeninjas.taskmanager;

/**
 * Created by Veronica on 2/18/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_TITLE = "title";
    public static final String CONTACTS_COLUMN_SUBJECT = "subject";
    public static final String CONTACTS_COLUMN_REQUIRED = "required"; //Time Required
    public static final String CONTACTS_COLUMN_DUE = "due";
    public static final String CONTACTS_COLUMN_DETAILS = "details";
    //public static final Integer DATABASE_VERSION = 2;
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL("DROP TABLE IF EXISTS contacts");

        db.execSQL(
                "create table contacts " +
                        "(integer id primary key, title text, phone text, subject text, required text, due text, details text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        //db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean insertData (String t, String deets, String subject, String req,String d) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", t);
        contentValues.put("details", deets);
        contentValues.put("subject", subject);
        contentValues.put("required", req);
        contentValues.put("due", d);
        long result = db.insert("contacts", null, contentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateData (Integer id, String t, String deets, String sub, String req,String d) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", t);
        contentValues.put("details", deets);
        contentValues.put("subject", sub);
        contentValues.put("required", req);
        contentValues.put("due", d);
        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts", "id = ? ", new String[] { Integer.toString(id) });
    }

}