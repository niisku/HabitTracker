package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Niina on 13.7.2017.
 */


//"Content" of the table structure (= Table and Columns' names) 
public final class HabitContract {

    private HabitContract() {

    }

    public static final class HabitEntry implements BaseColumns {

        //Table name:
        public final static String TABLE_NAME = "fluidIntakes";
        //ID column:
        public final static String _ID = BaseColumns._ID;
        //Other column names:
        public final static String COLUMN_DATE = "date";
        public final static String COLUMN_TYPE = "type";
        public final static String COLUMN_GLASSES = "glasses";
    }
}
