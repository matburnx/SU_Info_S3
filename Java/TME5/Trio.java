public class Trio {
    private static int compteur=0;
    private final int numero;
    private Personne[] trio={new Personne(),new Personne(),new Personne()};

    public Trio() {
        compteur++;
        numero=compteur;
    }

    public String toString() {
        String s="Trio "+numero+" : ";
        for(Personne p:trio) {
            s=s+p.toString()+" ";
        }
        return s;
    }

    public static int getCompteur() {
        return compteur;
    }
}
