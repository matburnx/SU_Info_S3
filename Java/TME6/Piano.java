public class Piano extends Instrument {
    public Piano(int prix, int poids, String type) {
        super(prix,poids);
        this.type=type;
    }

    public String toString() {
        return ("Piano "+type+" "+super.toString());
    }

    public void jouer() {
        System.out.println("Le piano "+type+" joue");
    }
}
