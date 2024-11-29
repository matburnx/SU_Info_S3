public class Orchestre {
    private int nbInstruments, max;
    private Instrument[] orchestre;

    public Orchestre(int max) {
        this.max=max;
        this.nbInstruments=0;
        orchestre= new Instrument[max];
    }

    public void ajouterInstrument(Instrument x) {
        if(nbInstruments<max) {
            orchestre[nbInstruments]=x;
            nbInstruments++;
        }
    }

    public void jouer() {
        for(int i =0; i<nbInstruments;i++) {
            orchestre[i].jouer();
        }
    }
}
