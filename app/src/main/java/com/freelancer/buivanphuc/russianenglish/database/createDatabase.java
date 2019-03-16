package com.freelancer.buivanphuc.russianenglish.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class createDatabase extends SQLiteOpenHelper {

    public static final String TB_HISTORY = "HISTORY";
    public static final String TB_HISTORY_ID = "ID";
    public static final String TB_HISTORY_WORD = "WORD";
    public static final String TB_HISTORY_DEFINITION = "definition";

    public static final String TB_FAVORETIS = "FAVORETIS";
    public static final String TB_FAVORETIS_ID = "ID";
    public static final String TB_FAVORETIS_WORD = "WORD";
    public static final String TB_FAVORETIS_DEFINITION = "definition";


    public createDatabase(Context context) {
        super(context, "English", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbHISTORY = "CREATE TABLE " + TB_HISTORY + " ( " + TB_HISTORY_ID + " INTEGER PRIMARY KEY ,"
                + TB_HISTORY_WORD + " TEXT , " + TB_HISTORY_DEFINITION + " TEXT )";

        String tbFAVORETIS = "CREATE TABLE " + TB_FAVORETIS + " ( " + TB_FAVORETIS_ID + " INTEGER PRIMARY KEY ,"
                + TB_FAVORETIS_WORD + " TEXT , " + TB_FAVORETIS_DEFINITION + " TEXT )";

        db.execSQL(tbFAVORETIS);
        db.execSQL(tbHISTORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase open() {
        return this.getWritableDatabase();
    }
}
