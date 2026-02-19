package app.sixthbca.labreport.LabNine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) { super(context, "UserDB", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Users(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users");
        onCreate(db);
    }

    public boolean insert(String name, String age) {
        ContentValues cv = new ContentValues();
        cv.put("name", name); cv.put("age", age);
        return getWritableDatabase().insert("Users", null, cv) != -1;
    }

    public Cursor getAll() { return getReadableDatabase().rawQuery("SELECT * FROM Users", null); }

    public boolean update(String id, String name, String age) {
        ContentValues cv = new ContentValues();
        cv.put("name", name); cv.put("age", age);
        return getWritableDatabase().update("Users", cv, "id=?", new String[]{id}) > 0;
    }

    public boolean delete(String id) {
        return getWritableDatabase().delete("Users", "id=?", new String[]{id}) > 0;
    }
}