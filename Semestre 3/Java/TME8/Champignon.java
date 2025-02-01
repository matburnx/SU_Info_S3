public class Champignon implements Ramassable {
    private String nom;
    private final double poids;

    public Champignon(String nom) {
        this.nom=nom;
        this.poids=Math.random()*3;
    }

    public double getPoids() { return poids; }

    public String toString() {
        return nom+" "+String.format("%.1f", poids)+"kg";
    }
}
