package Model;

import java.util.Date;

/**
 * @author EL GHACHI and mds youtube channel
 */
public class Profil {

    private static final int minFemme = 15;
    private static final int maxFemme = 30;
    private static final int minHomme = 10;
    private static final int maxHomme = 25;

    private Date dateMesure;
    private int poids;
    private int taille;
    private int age;
    private int sexe;
    private float img;
    private String message;

    public Profil(Date dateMesure,int poids, int taille, int age, int sexe) {
        this.dateMesure = dateMesure;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
    }

    public Date getDateMesure() {
        return dateMesure;
    }

    public int getPoids() {
        return poids;
    }

    public int getTaille() {
        return taille;
    }

    public int getAge() {
        return age;
    }

    public int getSexe() {
        return sexe;
    }

    public float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }

    public void calculIMG(){
        float tailleM = ((float)taille)/100;
        this.img = (float)((1.2*poids / (tailleM*tailleM)) + (0.23*age) - (10.83*sexe) - 5.4);
    }

    /**
     * calcule le IMG de l'utilisateur en suivant la formule mathématique
     */
    public void resultIMG(){
        int min;
        int max;
        if(this.sexe == 1){
            min = minHomme;
            max = maxHomme;
        }else{
            min = minFemme;
            max = maxFemme;
        }
        if(img < min){
            this.message = "trop maigre";
        }else{
            if(img < max){
                this.message = "normal";
            }else{
                this.message = "trop graisse";
            }
        }
    }
}
