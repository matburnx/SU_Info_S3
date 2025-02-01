import java.util.ArrayList;

public class Corbeille {
    private ArrayList<Fruit> liste;

    public Corbeille(int n) {
        liste = new ArrayList<Fruit>();
        
        for(int i=0;i<n;i++) {
            if(Math.random()>0.5) {
                liste.add(new Kiwi());
            } else {
                liste.add(new Pomme());
            }
        }
    }

    public void lister() {
        for(int i=0; i<liste.size();i++) {
            liste.get(i).afficher();
        }
    }

    public void methK() {
        for(Fruit f : liste) {
            if(f instanceof Kiwi) {
                ((Kiwi) f).methKiwi();
            }
        }
    }

    public int compterPomme() {
        int cpt=0;
        for(Fruit f : liste) {
            if(f instanceof Pomme) {
                cpt++;
            }
        }
        return cpt;
    }
}
