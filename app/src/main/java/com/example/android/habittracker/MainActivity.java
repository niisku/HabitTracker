package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.habittracker.data.DbHelper;
import com.example.android.habittracker.data.HabitContract.HabitEntry;

public class MainActivity extends AppCompatActivity {

    //mDbHelper used throughout the file; therefore instantiated here:
    private DbHelper mDbHelper;

    public String allData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiating the database:
        mDbHelper = new DbHelper(this);

    }

    //Method for inserting new data (with dummy data here):
    public void insertData() {

        //Makes the database instance writable (= here modifiable):
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        //ContentValues object:
        ContentValues values = new ContentValues();

        //Here just some dummy data:
        values.put(HabitEntry.COLUMN_DATE, 01.02);
        values.put(HabitEntry.COLUMN_TYPE, "Orange juice");
        values.put(HabitEntry.COLUMN_GLASSES, 2);

        db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor readDataCursor() {
        //Makes the database readable:
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        //Projection = Content of retrievable data:
        String projection[] = {
                HabitEntry._ID,
                HabitEntry.COLUMN_DATE,
                HabitEntry.COLUMN_TYPE,
                HabitEntry.COLUMN_GLASSES
        };

        //Query all data into cursor:
        Cursor dataRead = db.query(HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        return dataRead;

    }

    //This is just if all the data would be liked to store as String:
    public void presentableData() {

        try {

            // Finding & naming the columns' indexes:
            int idColumnIndex = readDataCursor().getColumnIndex(HabitEntry._ID);
            int dateColumnIndex = readDataCursor().getColumnIndex(HabitEntry.COLUMN_DATE);
            int typeColumnIndex = readDataCursor().getColumnIndex(HabitEntry.COLUMN_TYPE);
            int glassesColumnIndex = readDataCursor().getColumnIndex(HabitEntry.COLUMN_GLASSES);


            //Going through all the rows + saving the data:
            while (readDataCursor().moveToNext()) {

                int currentId = readDataCursor().getInt(idColumnIndex);
                float currentDate = readDataCursor().getFloat(dateColumnIndex);
                String currentType = readDataCursor().getString(typeColumnIndex);
                int currentGlasses = readDataCursor().getInt(glassesColumnIndex);

                allData = currentId + " | " +
                        currentDate + " | " +
                        currentType + " | " +
                        currentGlasses;
            }

        } finally {
            readDataCursor().close();
        }
    }
}
