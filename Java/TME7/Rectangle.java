public class Rectangle extends Figure2D {
    protected double largeur, longueur;

    public Rectangle(double largeur, double longueur) {
        this.largeur=largeur;
        this.longueur=longueur;
    }

    public double surface() {
        return longueur*largeur;
    }

    public double perimetre() {
        return 2*(longueur+largeur);
    }
}
