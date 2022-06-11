package Outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MonSQLiteOpenHelper extends SQLiteOpenHelper {

    public MonSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creationTableProfil = "create table Profil (" +
                "dateMesure TEXT PRIMARY KEY," +
                "poids INTEGER NOT NULL," +
                "taille INTEGER NOT NULL," +
                "age INTEGER NOT NULL," +
                "sexe INTEGER NOT NULL);";
        db.execSQL(creationTableProfil);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS Profil");

        // Create tables again
        onCreate(db);
    }
}
