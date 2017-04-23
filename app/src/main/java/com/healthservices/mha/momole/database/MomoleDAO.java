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


}
