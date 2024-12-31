package gedon.net.semaine3;

class Piece{
    private  String nom;
    public Piece(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom + " nom de la piece";
    }
}

class Composant {
    private int quantite;
    private Piece piece;

    public Composant(Piece piece, int quantite){
        this.piece = piece;
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    public Piece getPiece() {
        return piece;
    }
}

class Simple extends Piece{
    private String orientation;
    public Simple(String nom){
        super(nom);
        this.orientation = "aucune";
    }

    public Simple(String nom, String orientation){
        super(nom);
        this.orientation = orientation;
    }

    public String getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return getNom() + " orientee " + orientation;
    }
}

class Composee extends Piece{
    private int nombrePiece;

    public Composee(String nom,int nombrePiece) {
        super(nom);
        this.nombrePiece=nombrePiece;
    }

    public int taileMax(){
        return nombrePiece;
    }

    public void construire(Simple simple){
        if (nombrePiece > 0){
            nombrePiece--;
        }
    }
}
/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // dÃ©clare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}