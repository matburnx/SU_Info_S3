public class Velo extends SansMoteur{
    private int nb_vitesse;

    public Velo(String marque, int nb_vitesse){
        super(marque);
        this.nb_vitesse = nb_vitesse;
    }
    public String toString(){
        return(super.toString()+" nb_vitesse "+this.nb_vitesse);
    }
    public void transporter(String depart, String arrive){
        System.out.println("Le vélo "+super.id+" se déplace de "+depart+" à "+arrive);
    }
}
