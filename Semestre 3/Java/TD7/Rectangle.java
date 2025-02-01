public class Rectangle extends Shape {
    private double length, width;
    public Rectangle(double x, double y, double length, double width) {
        super(x,y);
        this.length=length;
        this.width=width;
    }

    public Rectangle() {
        this(0,0,1,1);
    }

    public double surface() {
        return length*width;
    }

    public String toString() {
        return "Rectangle Length : "+length+" Width : "+width+" "+super.toString();
    }
}
