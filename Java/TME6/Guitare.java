public class Guitare extends Instrument {
    public Guitare(int prix, int poids, String type) {
        super(prix,poids);
        this.type=type;
    }

    public String toString() {
        return ("Guitare "+type+" "+super.toString());
    }

    public void jouer() {
        System.out.println("La guitare "+type+" joue");
    }
}
