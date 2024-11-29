public class Tracteur {
    private Cabine cabine;
    private Roue petiteRoue1, petiteRoue2, grandeRoue1, grandeRoue2;

    public Tracteur(Cabine cabine, Roue petiteRoue1, Roue petiteRoue2, Roue grandeRoue1, Roue grandeRoue2) {
        this.cabine = cabine;
        this.petiteRoue1 = petiteRoue1;
        this.petiteRoue2 = petiteRoue2;
        this.grandeRoue1 = grandeRoue1;
        this.grandeRoue2 = grandeRoue2;
    }

    public Tracteur(Tracteur tracteur) {
        this.cabine = new Cabine(tracteur.cabine.getVolume(), tracteur.cabine.getCouleur());
        this.petiteRoue1 = new Roue(tracteur.petiteRoue1.getDiametre());
        this.petiteRoue2 = new Roue(tracteur.petiteRoue2.getDiametre());
        this.grandeRoue1 = new Roue(tracteur.grandeRoue1.getDiametre());
        this.grandeRoue2 = new Roue(tracteur.grandeRoue2.getDiametre());
    }

    public String toString() {
        return cabine.toString() + "\n" + petiteRoue1.toString() + "\n" + petiteRoue2.toString() + "\n" + grandeRoue1.toString() + "\n" + grandeRoue2.toString();
    }

    public void peindre(String couleur) {
        this.cabine.setCouleur(couleur);
    }
}
