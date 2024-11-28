public class BolColore extends Bol {
    private String couleur;
    public BolColore(int diam, String c) {
        super(diam);
        couleur=c;
    }

    public boolean equals(Object b) {
        if(b instanceof BolColore)
            if(this.couleur!=null && ((BolColore)b).couleur!=null)
                return (this.diametre==((BolColore)b).diametre) && (this.couleur==((BolColore)b).couleur);
            else
                return false;
        else
            return false;
    }
}
