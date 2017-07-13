package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by Niina on 13.7.2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "fluids.db";
    public static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //This for when the database is created for the FIRST TIME:
    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creating the table schema:
        String CREATE_TABLE = "CREATE_TABLE " + HabitEntry.TABLE_NAME + " (" +
                HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HabitEntry.COLUMN_DATE + " REAL NOT NULL, " +
                HabitEntry.COLUMN_TYPE + " TEXT NOT NULL, " +
                HabitEntry.COLUMN_GLASSES + " INTEGER NOT NULL );";

        db.execSQL(CREATE_TABLE);
    }

    //Method called in future updates:
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
