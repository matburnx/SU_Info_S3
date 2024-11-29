public class Camion extends AMoteur{
    private int volume_transporte;

    public Camion(String marque, int volume_transporte, int capacite_reservoir){
        super(marque, capacite_reservoir);
        this.volume_transporte = volume_transporte;
    }
    public String toString(){
        return super.toString();
    }
    public void transporter(String materiau, int km){
        if(super.enPanne()){
            System.out.println("Le camion "+super.id+" n'a plus d'essence");
        }else{
            System.out.println("Le camion "+super.id+ " a transporté des "+materiau+" sur "+km);
        }
    }    
}
