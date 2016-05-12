package com.example.ziom.jtr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Przemek on 2016-05-11.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "Tabela_Punkty.db";
    public static final String TABLE_NAME = "tabela_punktow";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NICK";
    public static final String COL_3 = "PUNKTY";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NICK TEXT UNIQUE,PUNKTY INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nick, long punkty) {
        SQLiteDatabase db;
        long result = 0;
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, nick);
        contentValues.put(COL_3, punkty);
        result = db.insertWithOnConflict(TABLE_NAME,null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllDAta() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME +
                " ORDER BY "+COL_3 + " DESC"
                , new String[] {});
    }

    /*public boolean usun(String nick) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "NICK = ?", new String[]{nick});
        return true;

    }
*/
    public boolean updateData(String nick, long punkty) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, nick);
        contentValues.put(COL_3, punkty);
        db.update(TABLE_NAME, contentValues, "NICK = ?", new String[] { nick });
        return true;


    }


}

