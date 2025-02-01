public class Cone {
    private static int nbCones=0;
    public final static double PI=3.14159;
    private double r,h;

    public Cone(double r, double h) {
        this.r=r;
        this.h=h;
        nbCones++;
    }
    public Cone() {
        this(Math.random()*10,Math.random()*10);
    }

    public double getVolume() {
        return (1./3.)*Cone.PI*r*r*h;
    }

    public String toString() {
        return String.format("Cone r=%.2fcm h=%.2fcm de volume %.2fcm3",r,h,this.getVolume());
    }

    public static int getNbCones() {
        return nbCones;
    }
}
