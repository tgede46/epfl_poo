package gedon.net.semaine2;
class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;
    private int poids;
    private int age;
    private String couleur;
    private int esperanceVie;
    private boolean clonee;

    public Souris(int poids, String couleur,int age,int esperanceVie) {
        this.poids = poids;
        this.couleur = couleur;
        this.age = age;
        this.esperanceVie = ESPERANCE_VIE_DEFAUT;
        System.out.println("Une nouvelle souris !");
    }

    public Souris(Souris souris) {
        this.poids = poids;
        this.couleur = couleur;
        this.age = age;
        this.esperanceVie = ESPERANCE_VIE_DEFAUT/4;
        this.clonee = true;
        System.out.println("le clonage d'une souris !");
    }

    public Souris(int poids, String couleur) {
        this.poids = poids;
        this.couleur = couleur;
        this.age = 0;
        this.esperanceVie = ESPERANCE_VIE_DEFAUT;
        System.out.println("Une nouvelle souris !");
    }
    public Souris(int poids, String couleur,int age) {
        this.poids = poids;
        this.couleur = couleur;
        this.age = age;
        this.esperanceVie = ESPERANCE_VIE_DEFAUT;
        System.out.println("Une nouvelle souris !");
    }

    @Override
    public String toString() {
        return "Une souris " + couleur + (clonee ? ", clonee,":"") + " de " + age + " mois et pesant " + poids + " grammes";
    }

    public void vieillir() {
        age++;
        if (clonee && age > esperanceVie/2) {
            couleur = "verte";
        }
    }

    public void evolue() {
        for (int i = 0; i < esperanceVie; i++) {
            vieillir();
        }
    }

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/

}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}