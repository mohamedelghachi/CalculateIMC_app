package Outils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

import Model.Profil;

public class AccessLocal {

    private String dbName = "coach.db";
    private int version = 1;
    private MonSQLiteOpenHelper mMonSQLiteOpenHelper;
    private SQLiteDatabase db;

    public AccessLocal(Context context) {
        mMonSQLiteOpenHelper = new MonSQLiteOpenHelper(context,dbName,null,version);
    }

    public void ajout(Profil profil){
        db = mMonSQLiteOpenHelper.getWritableDatabase();
        String reqAjout = "insert into Profil (dateMesure,poids,taille,age,sexe) values " +
                "('"+profil.getDateMesure()+"',"+profil.getPoids()+","+profil.getTaille()+","+profil.getAge()+","+profil.getSexe()+")";
        db.execSQL(reqAjout);
        db.close();
    }

    public Profil recupDernier(){
        Profil resultProfil = null;
        db = mMonSQLiteOpenHelper.getReadableDatabase();
        String reqRecupDernier = "select * from Profil";
        Cursor curseur = db.rawQuery(reqRecupDernier,null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            Date dateMesure = new Date();
            Integer poids = curseur.getInt(1);
            Integer taille = curseur.getInt(2);
            Integer age = curseur.getInt(3);
            Integer sexe = curseur.getInt(4);
            resultProfil = new Profil(dateMesure,poids,taille,age,sexe);
        }
        curseur.close();
        return resultProfil;
    }
}
