public class TestProjet {
    public static void main(String[] args) {
        System.out.println("Nombre de personnes : "+Personne.getNbPersonnes());
        Personne p1 = new Personne();
        Personne p2 = new Personne();
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println("Nombre de personnes : "+Personne.getNbPersonnes());

        Projet proj1 = new Projet("P3X-774");
        Projet proj2 = new Projet("P3R-233");
        Projet proj3 = new Projet();
        System.out.println(proj1.toString());
        System.out.println(proj2.toString());
        System.out.println(proj3.toString());

        System.out.println("Nombre de personnes : "+Personne.getNbPersonnes());
        System.out.println("Nombre de trios : "+Trio.getCompteur());
        System.out.println("Nombre de projets : "+Projet.getNbProjets());
    }
}
