public class Personne {
    private static int nbPersonnes=0;
    private final char lettre='A';
    private String nom;

    public Personne() {
        char newLetter = (char)(lettre+nbPersonnes);
        nbPersonnes++;
        nom="Individu"+newLetter;
    }

    public static int getNbPersonnes() {
        return nbPersonnes;
    }

    public String toString() {
        return nom;
    }
}
