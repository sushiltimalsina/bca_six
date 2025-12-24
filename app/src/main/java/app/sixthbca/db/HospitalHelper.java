package app.sixthbca.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HospitalHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDatabase.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "doctor";
    public HospitalHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryd = "CREATE TABLE " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, specialization TEXT, experience REAL)";
        db.execSQL(queryd);
    }


    public void insertDoctor(String name, String specialization, double experience){
//        String insertQuery = "INSERT INTO doctor (name, specialization, experience) VALUES (?, ?, ?);";
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("name", name);
        values.put("specialization", specialization);
        values.put("experience", experience);
        db.insert(TABLE_NAME, null,values);
    }


    public Cursor getAllDoctor() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
