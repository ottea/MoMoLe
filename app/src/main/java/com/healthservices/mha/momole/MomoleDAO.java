package com.healthservices.mha.momole.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by manji on 15.04.2017.
 */

public class MomoleDAO {
    public static final String TBL = "lebensmittel";
    public static final String TBL_ID = "id";
    public static final String TBL_TSTMP = "tstmp";
    public static final String TBL_AMOUNT = "amount";
    public static final String TBL_CATEGORY = "category";

    public static final String CREATE_TBL = "CREATE TABLE " + TBL +"("
            + TBL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_TSTMP + "INTEGER NOT NULL, "
            + TBL_AMOUNT + "REAL NOT NULL, "
            + TBL_CATEGORY + "TEXT)";

    private static MomoleDAO instance;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public static MomoleDAO getInstance(Context context) {
        if (instance == null){
            instance = new MomoleDAO(context);
        }
        return instance;
    }
}
