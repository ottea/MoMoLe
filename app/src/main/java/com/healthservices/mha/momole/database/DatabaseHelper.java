package com.healthservices.mha.momole.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by manji on 23.04.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "momole.db";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper instance;

    private DatabaseHelper(Context context, SQLiteDatabase.CursorFactory factory){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    public static DatabaseHelper getInstance (Context context){
        if (instance == null){
            instance = new DatabaseHelper(context, null);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        MomoleDAO.getInstance(null).onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        MomoleDAO.getInstance(null).onUpgrade(db, oldVersion, newVersion);
    }
}

