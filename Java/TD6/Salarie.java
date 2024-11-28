public class Salarie extends Personne {
    private double salaire;

    public Salarie(String nom, double salaire) {
        super(nom);
        this.salaire=salaire;
    }

    public double getSalaire() {return salaire;}

    public double prime() {
        return 0.05*this.getNbEnfants()*salaire;
    }

    protected void modifierNumTel(String numTel) {
        this.numTel=numTel;
    } 
}
