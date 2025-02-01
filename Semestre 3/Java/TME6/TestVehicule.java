public class TestVehicule {
    public static void main(String[] args){
        Velo v = new Velo("MyVTT", 17);
        v.transporter("Paris", "Lyon");
        v.rouler(10);
        v.toString();
        Voiture v2 = new Voiture("Merco", 5, 200);
        Camion v3 = new Camion("merco", 200, 300);
        Vehicule[] tab = new Vehicule[3];
        tab[0] =v;
        tab[1] = v2;
        tab[2] = v3;
        for(int i = 0; i<3; i++){
            tab[i].rouler(10);
        }
    }
}
