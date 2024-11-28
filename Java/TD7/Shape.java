public abstract class Shape {
    protected double x,y;
    
    public Shape(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public Shape() {
        this(0.,0.);
    }

    public String toString() {
        return "Position : ("+x+","+y+") Surface : "+surface();
    }

    public abstract double surface();
}
