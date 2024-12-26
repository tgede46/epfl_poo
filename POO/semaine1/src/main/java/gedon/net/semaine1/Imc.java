package gedon.net.semaine1;


// * Completez le programme a partir d'ici.
class Patient {
 //    definir les caracteristiques du patient
 private double masse;
 private double hauteur;

 //    definir une methode init
 public void init (double masse, double hauteur) {
 if (masse > 0 && hauteur > 0) {
 this.masse = masse;
 this.hauteur = hauteur;
 } else {
 this.masse = 0;
 this.hauteur = 0;
 }
 }
 //    definir une methode afficher
 public void afficher() {
 System.out.printf("Patient : masse = %.1f kg, hauteur = %.2f m\n", masse, hauteur);
 }

 //    definir une methode imc
 public double imc() {
 if (hauteur == 0) {
 return 0;
 } else {
 return masse / (hauteur * hauteur);
 }
 }
 }




/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
class Imc {
    public static void main(String[] args) {

        Patient quidam = new Patient();
        quidam.init(74.5, 1.75);
        quidam.afficher();
        System.out.println("IMC : " + quidam.imc());
        quidam.init( -2.0, 4.5);
        quidam.afficher();
    }
}