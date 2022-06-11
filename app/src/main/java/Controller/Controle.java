package Controller;

import android.content.Context;

import java.util.Date;

import Model.Profil;
import Outils.AccessLocal;

/**
 * class du controleur de l'application
 * @author EL GHACHI AND mds YOUTUBE CHANNEL
 */
public final class Controle {

    private static Controle instance = null;
    private static Profil profil = null;
    private static AccessLocal mAccessLocal;

    private Controle() {
        super();
    }

    /**
     * Création de l'instance
     * @return une instance de cette objet actuel
     */
    public static Controle getInstance(Context context) {
        if(instance == null){
            Controle.instance = new Controle();
            mAccessLocal = new AccessLocal(context);
            profil = mAccessLocal.recupDernier();
        }
        return instance;
    }

    /**
     * Création du profil.
     *
     * @param poids représente le poids de l'utilisateur
     * @param taille représente la taille de l'utilisateur (en centimetre)
     * @param age ...
     * @param sexe ...
     */
    public void creerProfil(int poids, int taille, int age, int sexe){
        profil = new Profil(new Date(), poids, taille, age, sexe);
        profil.calculIMG();
        profil.resultIMG();
        mAccessLocal.ajout(profil);
    }

    public float getIMG(){
        return profil.getImg();
    }

    public String getMessage(){
        return profil.getMessage();
    }

    public Date getDateMesure(){
        return profil.getDateMesure();
    }
    public Integer getPoids(){
        if(profil == null)
            return null;
        else
            return profil.getPoids();
    }
    public Integer getTaille(){
        if(profil == null)
            return null;
        else
            return profil.getTaille();
    }
    public Integer getAge(){
        if(profil == null)
            return null;
        else
            return profil.getAge();
    }
    public Integer getSexe(){
        if(profil == null)
            return null;
        else
            return profil.getSexe();
    }

}
