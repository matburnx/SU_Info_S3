public class Couple {
    private int x,y;
    public Couple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "("+x+","+y+")";
    }

    public Couple addition(Couple coupleB) {
        return new Couple(this.x+coupleB.x,this.y+coupleB.y);
    }
}