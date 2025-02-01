public class Vecteur3D {
    private double x,y,z;

    public Vecteur3D(double c1, double c2, double c3) {
        x=c1;
        y=c2;
        z=c3;
    }
    public Vecteur3D() {
        this(Math.random()*10,Math.random()*10,Math.random()*10);
    }

    public String toString() {
        return "("+x+","+y+","+z+")";
    }

    public Vecteur3D somme(Vecteur3D v2) {
        Vecteur3D vTot = new Vecteur3D(this.x+v2.x, this.y+v2.y, this.z+v2.z);
        return vTot;
    }

    public static Vecteur3D somme(Vecteur3D v1, Vecteur3D v2) {
        Vecteur3D v3 = new Vecteur3D(v1.x+v2.x, v1.y+v2.y, v1.z+v2.z);
        return v3;
    }
}
