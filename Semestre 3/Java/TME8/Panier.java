import java.util.ArrayList;

public class Panier extends ArrayList<Ramassable> {
    private final double poidsMax;
    private double poids;

    public Panier(double poidsMax) {
        this.poidsMax=poidsMax;
    }

    public double getPoids() { return poids; }

    @Override
    public boolean add(Ramassable obj) {
        if(obj.getPoids()+poids<poidsMax) {
            super.add(obj);
            poids+=obj.getPoids();
            System.out.println(obj.toString()+" est ajouté au panier");
            return true;
        } else {
            System.out.println(obj.toString()+" n'est pas ajouté au panier");
            return false;
        }
    }

    public int compterToxiques() {
        int cpt=0;
        for(int i=0;i<this.size();i++) {
            if(this.get(i) instanceof Toxique)
                cpt++;
        }
        return cpt;
    }

    public String toString() {
        String s="Panier contenant "+this.size()+" objets, dont "+this.compterToxiques()+" toxiques ";
        s=s+"("+String.format("%.1f", poids)+"kg sur "+String.format("%.1f", poidsMax)+"kg)";
        return s;
    }
}
