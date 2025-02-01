public class Roue {
    private int diametre;

    public Roue(int diametre) {
        this.diametre=diametre;
    }
    public Roue() {
        this(60);
    }

    public String toString() {
        return "Roue de diametre : " + this.diametre + " cm";
    }

    public int getDiametre() {
        return this.diametre;
    }
}
