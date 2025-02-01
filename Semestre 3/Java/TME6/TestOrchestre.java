public class TestOrchestre {
    public static void main(String[] args) {
        Piano p = new Piano(700, 300, "88 touches");
        Guitare g = new Guitare(500,2,"classique");

        Orchestre o = new Orchestre(10);
        o.ajouterInstrument(p);
        o.ajouterInstrument(g);
        o.jouer();
    }
}
