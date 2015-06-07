package com.tutorial.alonso.sistemascar;

/**
 * Created by alonso on 07/06/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class adminSql extends SQLiteOpenHelper {

    private Date fecha;
    // Database Version
    private static final int DATABASE_VERSION  = 1;
    // Database Name
    private static final String DATABASE_NAME = "Pro";

    public adminSql(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tareas(cve integer primary key AUTOINCREMENT, nombre text, marteria text, entrega data, prioridad integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("drop table if exists alumnos");
        db.execSQL("create table tareas(cve integer primary key, nombre text, marteria text, entrega data, prioridad integer)");
    }

    // tarea table name
    private static final String TABLE_TAREAS = "tareas";

    // Books Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NOMBRE = "nombre";
    private static final String KEY_MATERIA = "materia";
    private static final String KEY_ENTREGA = "entrega";
    private static final String KEY_PRIORIDAD = "prioridad";

    //private static final String[] COLUMNS = {KEY_ID,KEY_NOMBRE,KEY_MATERIA,KEY_ENTREGA,KEY_PRIORIDAD};


    public void addTarea(tarea tarea){
        //for logging
        Log.d("tareas->", tarea.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_NOMBRE, tarea.nombre); // get title
        values.put(KEY_MATERIA, tarea.materia); // get author
        values.put(KEY_ENTREGA, tarea.fechaEntrega); // get author
        values.put(KEY_PRIORIDAD, tarea.prioridad); // get author

        // 3. insert
        db.insert(TABLE_TAREAS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public List<tarea> getAllBooks() {
        List<tarea> books = new LinkedList<tarea>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_TAREAS;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        tarea tarea = null;
        if (cursor.moveToFirst()) do {
            tarea = new tarea();
            tarea.id = Integer.parseInt(cursor.getString(0));
            tarea.nombre = cursor.getString(1);
            tarea.materia = cursor.getString(2);
            tarea.fechaEntrega = Integer.parseInt(cursor.getString(3));
            tarea.prioridad = Integer.parseInt(cursor.getString(4));

            // Add book to books
            books.add(tarea);
        } while (cursor.moveToNext());

        Log.d("getAlltareas()", books.toString());

        // return books
        return books;
    }


}