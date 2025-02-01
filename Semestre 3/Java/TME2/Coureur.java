public class Coureur {
    private int numDossard;
    private double tempsAu100;
    private boolean possedeTemoin;

    public Coureur(int numDossard) {
        this.numDossard = numDossard;
        tempsAu100 = Math.random()*(16-12)+12;
        possedeTemoin = false;
    }

    public Coureur() {
        this((int)(Math.random()*1001+1));
    }

    public int getNumDossard() {
        return numDossard;
    }

    public double getTempsAu100() {
        return tempsAu100;
    }

    public boolean getPossedeTemoin() {
        return possedeTemoin;
    }

    public void setPossedeTemoin(boolean possedeTemoin) {
        this.possedeTemoin = possedeTemoin;
    }

    public String toString() {
        String s = "Coureur " + numDossard + " tempsAu100 : " + String.format("%.2f",tempsAu100) + "s au 100m possedeTemoin : ";
        if(possedeTemoin)
            s+="oui";
        else
            s+="non";
        return s;
    }

    public void passeTemoin(Coureur c) {
        System.out.println("moi, coureur "+this.numDossard+", je passe le témoin au coureur "+c.numDossard);
        c.setPossedeTemoin(true);
        this.possedeTemoin=false;
    }

    public void courir() {
        System.out.println("je suis le coureur "+this.numDossard+" et je cours");
    }
}
