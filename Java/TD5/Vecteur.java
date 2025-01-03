public class Vecteur {
    private final int id;
    private static int cpt=0;
    public final double x,y;

    public Vecteur(double x, double y) {
        id = cpt;
        cpt++;
        this.x = x;
        this.y = y;
    }

    public static int getCpt() {
        return cpt;
    }

    public int getCpt2() {
        return cpt;
    }

    public int getId() {
        return id;
    }

    public String format(Vecteur v) {
        return String.format("[%5.2f, %5.2f]", v.x, v.y);
    }
}
