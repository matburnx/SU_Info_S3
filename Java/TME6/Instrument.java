public abstract class Instrument {
    private int poids, prix;
    protected String type="";

    public Instrument(int prix, int poids) {
        this.prix=prix;
        this.poids=poids;
    }

    public String toString() {
        return "poids : "+poids+" kg, prix : "+prix+" euros";
    }

    public abstract void jouer() ;
}