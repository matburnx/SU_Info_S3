public class Vache extends APattes {
    private int qteLait;

    public Vache(int age, String name) {
        super(age, name);
        this.nbPattes=4;
        this.qteLait=(int)(Math.random()*(30-5)+5);
    }

    public String toString() {
        return "Vache : "+super.toString()+" Quantite de lait par jour : "+qteLait;
    }

    public void crier() {
        System.out.println("Meuh");
    }
}
