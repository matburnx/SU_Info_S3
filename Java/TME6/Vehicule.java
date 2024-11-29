public class Vehicule {
    private static int cpt = 0;
    protected final int id;
    protected final String marque;
    protected double dist;

    public Vehicule(String marque){
        this.id = cpt;
        this.marque = marque;
        this.dist = 0;
        cpt = cpt +1;
    }

    public String toString(){
        return (this.id+" de marque "+this.marque);
    }
    public void rouler(double distance){
        this.dist = this.dist+distance;
        System.out.println(toString()+" a roulé "+this.dist+" km");
    }
}
