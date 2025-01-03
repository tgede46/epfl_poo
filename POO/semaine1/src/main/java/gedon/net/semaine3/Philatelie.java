
package gedon.net.semaine3;

import java.util.ArrayList;

class Timbre {

    public static final int ANNEE_COURANTE = 2016;
    public static final int VALEUR_TIMBRE_DEFAUT = 1;
    public static final String PAYS_DEFAUT = "Suisse";
    public static final String CODE_DEFAUT = "lambda";

    public static final int BASE_1_EXEMPLAIRES = 100;
    public static final int BASE_2_EXEMPLAIRES = 1000;
    public static final double PRIX_BASE_1 = 600;
    public static final double PRIX_BASE_2 = 400;
    public static final double PRIX_BASE_3 = 50;

    private String code;
    private int annee;
    private String pays;
    private double valeurFaciale;

    public  Timbre(String code, int annee, String pays, double valeurFaciale) {
        this.code = code;
        this.annee = annee;
        this.pays = pays;
        this.valeurFaciale = valeurFaciale;
    }
    public Timbre() {
        this(CODE_DEFAUT, ANNEE_COURANTE, PAYS_DEFAUT, VALEUR_TIMBRE_DEFAUT);
    }

    public double vente() {
        return 2.5 * age() * valeurFaciale;
    }

    @Override
    public String toString() {
        return "Timbre de code " + code + " datant de " + annee + " (provenance " + pays + ") ayant pour valeur faciale " + valeurFaciale + " francs";
    }

    public int age() {
        return ANNEE_COURANTE - annee;
    }

    public double getValeurFaciale() {
        return valeurFaciale;
    }

    public int getAnnee() {
        return annee;
    }

    public String getCode() {
        return code;
    }

    public String getPays() {
        return pays;
    }

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
}

class Rare extends Timbre{

    private  int exemplaires;

    public Rare(String code, int annee, String pays, double valeurFaciale, int exemplaires) {
        super(code, annee, pays, valeurFaciale);
        this.exemplaires = exemplaires;
    }

    public int getExemplaires() {
        return exemplaires;
    }

    @Override
    public String toString() {
        return "Timbre de code " + getCode() + " datant de " + getAnnee() + " (provenance " + getPays() + ") ayant pour valeur faciale " + getValeurFaciale() + " francs\nNombre d'exemplaires -> " + getExemplaires() ;
    }
}

class Commemoratif extends Timbre{

    public Commemoratif(String code, int annee, String pays, double valeurFaciale) {
        super(code, annee, pays, valeurFaciale);
    }

    @Override
    public double vente() {
        return super.vente() * 2;
    }

    @Override
    public String toString() {
        return "Timbre de code " + getCode() + " datant de " + getAnnee() + " (provenance " + getPays() + ") ayant pour valeur faciale " + getValeurFaciale() + " francs\nTimbre celebrant un evenement";
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

class Philatelie {

    public static void main(String[] args) {

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale,
        // nombre d'exemplaires
        Rare t1 = new Rare("Guarana-4574", 1960, "Mexique", 0.2, 98);

        // ordre des parametres: nom, annee d'emission, pays, valeur faciale
        Commemoratif t2 = new Commemoratif("700eme-501", 2002, "Suisse", 1.5);
        Timbre t3 = new Timbre("Setchuan-302", 2004, "Chine", 0.2);

        Rare t4 = new Rare("Yoddle-201", 1916, "Suisse", 0.8, 3);


        ArrayList<Timbre> collection = new ArrayList<Timbre>();

        collection.add(t1);
        collection.add(t2);
        collection.add(t3);
        collection.add(t4);

        for (Timbre timbre : collection) {
            System.out.println(timbre);
            System.out.println("Prix vente : " + timbre.vente() + " francs");
            System.out.println();
        }
    }
}
