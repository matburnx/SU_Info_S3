public class Point {
    private int posx, posy;

    public Point(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }

    public Point() {
        this((int)(Math.random()*10),(int)(Math.random()*10));
    }

    public String toString() {
        return "("+this.posx+","+this.posy+")";
    }

    public int getPosX() {
        return posx;
    }

    public int getPosY() {
        return posy;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow((p.posx-this.posx),2) + Math.pow((p.posy-this.posy),2));
    }

    public void deplaceToi(int newx, int newy) {
        this.posx = newx;
        this.posy = newy;
    }
}
