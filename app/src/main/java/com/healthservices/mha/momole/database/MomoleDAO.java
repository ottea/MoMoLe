package com.healthservices.mha.momole.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by manji on 23.04.2017.
 */

public class MomoleDAO {
    public static final String TBL_LM = "lebensmittel";
    public static final String TBL_LM_ID = "id";
    public static final String TBL_LM_TSTMP = "tstmp";
    public static final String TBL_LM_AMOUNT = "amount";
    public static final String TBL_LM_CATEGORY = "category";

    public static final String TBL_B = "beschwerden";
    public static final String TBL_B_ID = "id";
    public static final String TBL_B_TSTMP = "tstmp";
    public static final String TBL_B_AMOUNT = "amount";
    public static final String TBL_B_CATEGORY = "category";

    public static final String TBL_N = "notizen";
    public static final String TBL_N_ID = "id";
    public static final String TBL_N_TSTMP = "tspmp";
    public static final String TBL_N_AMOUNT = "amount";

    public static final String CREATE_TBL = "CREATE TBL " + TBL_LM + "("
            + TBL_LM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_LM_TSTMP + " INTEGER NOT NULL, "
            + TBL_LM_AMOUNT + " REAL NOT NULL, "
            + TBL_LM_CATEGORY + " TEXT";

    public static final String CREATE_TBL = "CREATE TBL " + TBL_B + "("
            + TBL_B_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_B_TSTMP + " INTEGER NOT NULL, "
            + TBL_B_AMOUNT + " REAL NOT NULL, "
            + TBL_B_CATEGORY + " TEXT";

    public static final String CREATE_TBL = "CREATE TBL " + TBL_N + "("
            + TBL_N_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_N_TSTMP + " INTEGER NOT NULL, "
            + TBL_N_AMOUNT + " REAL NOT NULL";



}
