import java.util.ArrayList;

class Auteur {

    private String nom;
    private boolean prime;

    public Auteur(String nom, boolean prime) {
        this.nom = nom;
        this.prime = prime;
    }

    public String getNom() {
        return nom;
    }

    public boolean getPrix() {
        if (prime) {
            return true;
        } else {
            return false;
        }
    }
    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    // Completer la classe Auteur ici
}

class Oeuvre
{
    private String titre;
    private String langue;
    private Auteur auteur;

    public Oeuvre(String titre,Auteur auteur,String langue){
        this.titre=titre;
        this.auteur=auteur;
        this.langue=langue;
    }

    public String getTitre() {
        return titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public String getLangue() {
        return langue;
    }

    public void afficher(){
        System.out.println(titre + ", " + auteur.getNom() + ", en " + langue);
    }

    // Completer la classe Oeuvre ici
}

class Exemplaire{

    private Oeuvre oeuvre;

    public Exemplaire(Oeuvre oeuvre){
        this.oeuvre=oeuvre;
        System.out.println("Nouvel exemplaire -> " + oeuvre.getTitre() + ", " + oeuvre.getAuteur().getNom() + ", en " + oeuvre.getLangue());
    }

    public Exemplaire(Exemplaire exemplaire){
        this.oeuvre=exemplaire.oeuvre;
        System.out.println("Copie d'un exemplaire de -> " + oeuvre.getTitre() + ", " + oeuvre.getAuteur().getNom() + ", en " + oeuvre.getLangue());
    }

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void afficher(){
        System.out.println("Exemplaire de -> " + oeuvre.getTitre() + ", " + oeuvre.getAuteur().getNom() + ", en " + oeuvre.getLangue());
    }

}


class Bibliotheque {

    private String nom;
    private ArrayList<Exemplaire> exemplaires = new ArrayList<Exemplaire>();

    public Bibliotheque(String nom) {
        this.nom = nom;
        System.out.println("La bibliotheque " + nom + " est ouverte !");
    }

    public String getNom() {
        return nom;
    }

    public int getNbExemplaires() {
        return exemplaires.size();
    }

    public void stocker(Oeuvre oeuvre) {
        Exemplaire exemplaire = new Exemplaire(oeuvre);
        exemplaires.add(exemplaire);
    }

    public void stocker(Oeuvre oeuvre, int n) {
        for (int i = 0; i < n; i++) {
            Exemplaire exemplaire = new Exemplaire(oeuvre);
            exemplaires.add(exemplaire);
        }
    }

    public ArrayList<Exemplaire> listerExemplaires() {
        return exemplaires;
    }

    public ArrayList<Exemplaire> listerExemplaires(String langue) {
        ArrayList<Exemplaire> exemplairesLangue = new ArrayList<Exemplaire>();
        for (Exemplaire exemplaire : exemplaires) {
            if (exemplaire.getOeuvre().getLangue().equals(langue)) {
                exemplairesLangue.add(exemplaire);
            }
        }
        return exemplairesLangue;
    }

    public int compterExemplaires(Oeuvre oeuvre) {
        int count = 0;
        for (Exemplaire exemplaire : exemplaires) {
            if (exemplaire.getOeuvre().getTitre().equals(oeuvre.getTitre())) {
                count++;
            }
        }
        return count;
    }

    public void afficherAuteur() {
        ArrayList<Auteur> auteurs = new ArrayList<Auteur>();
        for (Exemplaire exemplaire : exemplaires) {
            Auteur auteur = exemplaire.getOeuvre().getAuteur();
            if (auteur.getPrix() && !auteurs.contains(auteur)) {
                auteurs.add(auteur);
                System.out.println(auteur.getNom());
            }
        }


    }
}
// completer les autres classes ici


/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
    /*******************************************
     * Ce qui suit est propose' pour vous aider
     * dans vos tests, mais votre programme sera
     * teste' avec d'autres donnees.
     *******************************************/
    public class Biblio {

        public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
            for (Exemplaire exemplaire : exemplaires) {
                System.out.print("\t");
                exemplaire.afficher();
            }
        }

        public static void main(String[] args) {
            // create and store all the exemplaries
            Auteur a1 = new Auteur("Victor Hugo", false);
            Auteur a2 = new Auteur("Alexandre Dumas", false);
            Auteur a3 = new Auteur("Raymond Queneau", true);

            Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
            Oeuvre o2 = new Oeuvre("L'Homme qui rit", a1, "francais");
            Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
            Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
            Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

            Bibliotheque biblio = new Bibliotheque("municipale");
            biblio.stocker(o1, 2);
            biblio.stocker(o2);
            biblio.stocker(o3, 3);
            biblio.stocker(o4);
            biblio.stocker(o5);

            // ...
            System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
            afficherExemplaires(biblio.listerExemplaires());
            String langue = "anglais";
            System.out.println("Les exemplaires en " + langue + " sont  ");
            afficherExemplaires(biblio.listerExemplaires(langue));
            System.out.println("Les auteurs a succes sont  ");
            biblio.afficherAuteur();
            System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
            System.out.println(" de  " + o3.getTitre());
        }
    }

