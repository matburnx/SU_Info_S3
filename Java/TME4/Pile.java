public class Pile {
    private int nbA=0;
    private Assiette[] pile;

    public Pile(int max) {
        pile = new Assiette[max];
    }

    public boolean estVide() {
        return nbA == 0;
    }

    public boolean estPleine() {
        return nbA == pile.length;
    }

    public void empiler(Assiette a) {
        if (!this.estPleine()) {
            pile[nbA]=a;
            nbA++;
        }
    }

    public Assiette depiler() {
        if (!this.estVide()) {
            Assiette a = pile[nbA-1];
            pile[nbA-1]=null;
            nbA--;
            return a;
        }
        return null;
    }

    public String toString() {
        String s="";
        for(int i=nbA-1; i>=0; i--) {
            s=s+pile[i].toString()+"\n";
        }
        return s;
    }
}
