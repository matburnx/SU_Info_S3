public class Triangle {
    Point s1, s2, s3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.s1 = p1;
        this.s2 = p2;
        this.s3 = p3;
    }

    public Triangle(Triangle triangle) {
        this.s1 = new Point(triangle.s1.getPosX(), triangle.s1.getPosY());
        this.s2 = new Point(triangle.s2.getPosX(), triangle.s2.getPosY());
        this.s3 = new Point(triangle.s3.getPosX(), triangle.s3.getPosY());
    }

    public Triangle() {
        this(new Point(), new Point(), new Point());
    }

    public String toString() {
        return "{"+this.s1.toString()+";"+this.s2.toString()+";"+this.s3.toString()+"}";
    }

    public double getPerimetre() {
        return (s1.distance(s2) + s2.distance(s3) + s3.distance(s1));
    }
}
