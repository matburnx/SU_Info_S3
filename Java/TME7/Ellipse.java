public class Ellipse extends Figure2D {
    protected double a, b;

    public Ellipse(double a, double b) {
        this.a=a;
        this.b=b;
    }

    public double surface() {
        return Math.PI*a*b;
    }

    public double perimetre() {
        return 2*Math.PI*Math.sqrt((a*a+b*b)/2);
    }
}
