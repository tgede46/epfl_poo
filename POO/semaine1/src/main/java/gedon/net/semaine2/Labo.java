package gedon.net.semaine2;
class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;
    private int poids;
    private int age;
    private String couleur;
    private int esperanceVie;
    private boolean clonee;

    // Constructeur principal
    public Souris(int poids, String couleur, int age, int esperanceVie) {
        this.poids = poids;
        this.couleur = couleur;
        this.age = age;
        this.esperanceVie = esperanceVie;
        System.out.println("Une nouvelle souris !");
    }

    // Surcharge avec espérance de vie par défaut
    public Souris(int poids, String couleur) {
        this(poids, couleur, 0, ESPERANCE_VIE_DEFAUT);
    }

    // Constructeur de clonage
    public Souris(Souris souris) {
        this.poids = souris.poids;
        this.couleur = souris.couleur;
        this.age = souris.age;
        this.esperanceVie = (int) (souris.esperanceVie * 0.8); // Réduction de 20%
        this.clonee = true;
        System.out.println("Clonage d'une souris !");
    }

    @Override
    public String toString() {
        return "Une souris " + couleur + (clonee ? ", clonee, " : ", ") + "de " + age + " mois et pesant " + poids + " grammes.";
    }

    public void vieillir() {
        age++;
        if (clonee && age > esperanceVie / 2) {
            couleur = "verte"; // Couleur change après la moitié de vie
        }
    }

    public void evolue() {
        while (age < esperanceVie) {
            vieillir();
        }
    }
}

/*******************************************
 * Ne rien modifier après cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2, 36);
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
