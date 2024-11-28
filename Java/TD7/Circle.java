public class Circle extends Shape {
    private double radius;
    public Circle(double x, double y, double r) {
        super(x,y);
        this.radius=r;
    }

    public Circle() {
        this(0,0,1);
    }

    public double surface() {
        return Math.PI*radius*radius;
    }

    public String toString() {
        return "Circle Radius : "+radius+" "+super.toString();
    }
}
