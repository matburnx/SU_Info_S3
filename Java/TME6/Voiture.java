public class Voiture extends AMoteur{
    private int nb_places;
    public Voiture(String marque, int nb_places, int capacite_reservoir){
        super(marque, capacite_reservoir);
        this.nb_places = nb_places;
    }
    public String toString(){
        return super.toString();
    }
    public void transporter(int nbPers, int km){
        if(super.enPanne()){
            System.out.println("La voiture "+super.id+" n'a plus d'essence");
        }else{
            System.out.println("La voiture "+super.id+" transporte "+nbPers+" personnes sur"+km+" km");
        }
    }
}
