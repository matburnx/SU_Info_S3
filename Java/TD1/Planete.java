public class Planete {
    private String nom;
    private double rayon;

    public Planete(String n, double r) {
        nom=n;
        rayon=r;
    }

    public String toString() {
        String s="Planete " + nom;
        s+=" de rayon "+rayon;
        return s;
    }

    public double getRayon() {
        return rayon;
    }
}
