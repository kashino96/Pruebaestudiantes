package facci.pml.estudiantesdb.database.entities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;

import java.util.ArrayList;

import facci.pml.estudiantesdb.database.Helper.EstudianteHelper;
import facci.pml.estudiantesdb.database.Modelo.Estudiante;

public class EstudianteItemDB {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private EstudianteHelper dbHelper;

    public EstudianteItemDB(Context context) {
        dbHelper = new EstudianteHelper(context);

    }

    public static abstract class EstudianteElementEntry implements BaseColumns {
        public static final String TABLE_NAME = "Estudiantes";
        public static final String COLUMN_NAME_CEDULA = "cedula";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_APELLIDO = "apellido";
        public static final String COLUMN_NAME_FECHA_NACIMIENTO = "fecha_nacimiento";
        public static final String COLUMN_NAME_FACULTAD = "facultad";
        public static final String COLUMN_NAME_CIUDAD = "ciudad";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + COMMA_SEP +
                COLUMN_NAME_CEDULA + TEXT_TYPE +  COMMA_SEP + COLUMN_NAME_NOMBRE  + TEXT_TYPE+ COMMA_SEP  + COLUMN_NAME_APELLIDO + TEXT_TYPE
                + COMMA_SEP + COLUMN_NAME_FECHA_NACIMIENTO + TEXT_TYPE + COMMA_SEP + COLUMN_NAME_FACULTAD + TEXT_TYPE +
                COMMA_SEP + COLUMN_NAME_CIUDAD + TEXT_TYPE +" )";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public void inserProf(String cedula, String nombre, String apellido, String Fecha, String facultad, String ciudad) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EstudianteElementEntry.COLUMN_NAME_CEDULA, cedula);
        contentValues.put(EstudianteElementEntry.COLUMN_NAME_NOMBRE, nombre);
        contentValues.put(EstudianteElementEntry.COLUMN_NAME_APELLIDO, apellido);
        contentValues.put(EstudianteElementEntry.COLUMN_NAME_FECHA_NACIMIENTO, Fecha);
        contentValues.put(EstudianteElementEntry.COLUMN_NAME_FACULTAD, facultad);
        contentValues.put(EstudianteElementEntry.COLUMN_NAME_CIUDAD, ciudad);
        dbHelper.getWritableDatabase().insert(EstudianteElementEntry.TABLE_NAME, null, contentValues);


    }

    public ArrayList<Estudiante> getAllItems() {

        ArrayList<Estudiante> profesorItems = new ArrayList<>();

        String[] allColumns = { EstudianteElementEntry._ID,
                EstudianteElementEntry.COLUMN_NAME_CEDULA, EstudianteElementEntry.COLUMN_NAME_NOMBRE, EstudianteElementEntry.COLUMN_NAME_APELLIDO
                , EstudianteElementEntry.COLUMN_NAME_FECHA_NACIMIENTO, EstudianteElementEntry.COLUMN_NAME_FACULTAD, EstudianteElementEntry.COLUMN_NAME_CIUDAD};

        Cursor cursor = dbHelper.getReadableDatabase().query(
                EstudianteElementEntry.TABLE_NAME,    // The table to query
                allColumns,                         // The columns to return
                null,                               // The columns for the WHERE clause
                null,                               // The values for the WHERE clause
                null,                               // don't group the rows
                null,                               // don't filter by row groups
                null                                // The sort order
        );

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            Estudiante profesorIte = new Estudiante(getItemId(cursor), getCedula(cursor), getNombre(cursor), getApellido(cursor)
                    , getFecha(cursor), getFacultad(cursor), getCiudad(cursor));
            profesorItems.add(profesorIte);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        dbHelper.getReadableDatabase().close();
        return profesorItems;
    }

    private long getItemId(Cursor cursor) {
        return cursor.getLong(cursor.getColumnIndexOrThrow(EstudianteElementEntry._ID));
    }

    private String getCedula(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow(EstudianteElementEntry.COLUMN_NAME_CEDULA));
    }

    private String getNombre(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow(EstudianteElementEntry.COLUMN_NAME_NOMBRE));
    }

    private String getApellido(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow(EstudianteElementEntry.COLUMN_NAME_APELLIDO));
    }

    private String getFecha(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow(EstudianteElementEntry.COLUMN_NAME_FECHA_NACIMIENTO));
    }

    private String getFacultad(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow(EstudianteElementEntry.COLUMN_NAME_FACULTAD));
    }

    private String getCiudad(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow(EstudianteElementEntry.COLUMN_NAME_CIUDAD));
    }
}
