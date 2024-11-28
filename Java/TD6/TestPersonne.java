public class TestPersonne {
    public static void main(String[] args) {
        Personne p = new Personne("Albert");
        p.ajouterEnfant();
        
        Etudiant e = new Etudiant("Ahmed", null, "L2");
        e.ajouterEnfant();
        e.estEnL2();
        e.afficherInfo();

        Salarie s1 = new Salarie("Amelle",1200.0);
    }
}
