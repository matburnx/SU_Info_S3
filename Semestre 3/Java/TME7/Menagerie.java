public class Menagerie {
    private Animal[] liste;
    private int nbAnimaux;
    private final int taille;

    public Menagerie(int taille) {
        this.taille=taille;
        this.liste=new Animal[taille];
        this.nbAnimaux=0;
    }

    public void ajouter(Animal a) {
        if(nbAnimaux<taille) {
            liste[nbAnimaux]=a;
            nbAnimaux++;
        }
    }

    public String toString() {
        String s="";
        for(int i=0;i<nbAnimaux;i++) {
            s=s+liste[i].toString()+"\n";
        }
        return s;
    }

    public void midi() {
        for(int i=0;i<nbAnimaux;i++) {
            liste[i].crier();
        }
    }

    public void vieillirTous() {
        for(int i=0;i<nbAnimaux;i++) {
            liste[i].vieillir();
        }
    }
}
