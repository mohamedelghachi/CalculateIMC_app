package Controller;

import Model.Profil;

/**
 * class du controleur de l'application
 * @author EL GHACHI AND mds YOUTUBE CHANNEL
 */
public final class Controle {

    private static Controle instance = null;

    private Profil profil;

    private Controle() {
        super();
    }

    /**
     * Création de l'instance
     * @return une instance de cette objet actuel
     */
    public static Controle getInstance() {
        if(instance == null){
            Controle.instance = new Controle();
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
        profil = new Profil(poids, taille, age, sexe);
        profil.calculIMG();
        profil.resultIMG();
    }

    public float getIMG(){
        return profil.getImg();
    }

    public String getMessage(){
        return profil.getMessage();
    }
}
