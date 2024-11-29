public class Projet {
    private static int nbProjets=0;
    private String nom;
    private Trio trio;

    public Projet(String nom) {
        nbProjets++;
        this.nom=nom;
        trio = new Trio();
    }
    public Projet() {
        this(Alea.chaine());
    }

    public String toString() {
        return "Projet "+nom+" "+trio.toString();
    }

    public static int getNbProjets() {
        return nbProjets;
    }
}
