public abstract class AMoteur extends Vehicule{
    private int capacite_reservoir;
    private int niveau_d_essence;

    public AMoteur(String marque, int capacite_reservoir){
        super(marque);
        this.capacite_reservoir = capacite_reservoir;
        this.niveau_d_essence = 0;
    }

    public void approvisionner(double nbLitres){
        niveau_d_essence+= nbLitres;
    }

    public boolean enPanne(){
        return niveau_d_essence<=0;
    }

    public String toString(){
        return (super.toString()+" à moteur"+" capacité reservoir :"+this.capacite_reservoir+" niveau essence "+this.niveau_d_essence);
    }

    public abstract void transporter();
}