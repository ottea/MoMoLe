package com.healthservices.mha.momole.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

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

    public static final String CREATE_TBL_LM = "CREATE TBL " + TBL_LM + "("
            + TBL_LM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_LM_TSTMP + " INTEGER NOT NULL, "
            + TBL_LM_AMOUNT + " REAL NOT NULL, "
            + TBL_LM_CATEGORY + " TEXT";

    public static final String CREATE_TBL_B = "CREATE TBL " + TBL_B + "("
            + TBL_B_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_B_TSTMP + " INTEGER NOT NULL, "
            + TBL_B_AMOUNT + " REAL NOT NULL, "
            + TBL_B_CATEGORY + " TEXT";

    public static final String CREATE_TBL_N = "CREATE TBL " + TBL_N + "("
            + TBL_N_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TBL_N_TSTMP + " INTEGER NOT NULL, "
            + TBL_N_AMOUNT + " REAL NOT NULL";

    private static MomoleDAO instance;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public static MomoleDAO getInstance(Context context){
        if (instance == null){
            instance = new MomoleDAO(context);
        }
        return instance;
    }

    private MomoleDAO(Context context){
        dbHelper = DatabaseHelper.getInstance(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public void onCreate(SQLiteDatabase database){
        database.execSQL(CREATE_TBL_LM);
        database.execSQL(CREATE_TBL_B);
        database.execSQL(CREATE_TBL_N);
    }

    public void onUpgrade(SQLiteDatabase database, int oldVersion int newVersion){

    }

    public Momole getMomole(long id){
        open();
        Cursor cursor = database.query(TBL_LM,TBL_B,TBL_N //TBL
                ,null, //null returns all columns /fields
                TBL_LM_ID, TBL_B_ID, TBL_N + "=?", // Selection (WHERE [field]=?)
                new String[]{String.valueOf(id)},
                null,
                null
                null
                null);
        if (cursor.moveToFirst()){
            return readFromCursor(cursor);
        }
        cursor.close();
        close();
        return null;
    }

    public List<Momole> getAllMomoleAfter (long timestamp){
        open();
        Cursor cursor = database.query()
    }
}
