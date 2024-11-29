public class Cabine {
    private int volume;
    private String couleur;

    public Cabine(int volume, String couleur) {
        this.volume = volume;
        this.couleur = couleur;
    }

    public String toString() {
        return "Cabine de volume " + this.volume + " m3 et de couleur " + this.couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return this.couleur;
    }

    public int getVolume() {
        return this.volume;
    }
}
