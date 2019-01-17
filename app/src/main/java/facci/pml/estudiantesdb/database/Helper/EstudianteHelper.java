package facci.pml.estudiantesdb.database.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import facci.pml.estudiantesdb.database.entities.EstudianteItemDB;

public class EstudianteHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Estudiante.db";

    public EstudianteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EstudianteItemDB.EstudianteElementEntry.CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(EstudianteItemDB.EstudianteElementEntry.DELETE_TABLE);
        onCreate(db);
    }
}