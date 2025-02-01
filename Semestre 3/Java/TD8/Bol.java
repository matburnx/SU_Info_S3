public class Bol {
    protected int diametre;
    public Bol(int diametre) {
        this.diametre=diametre;
    }

    public boolean equals(Object b) {
        if((b instanceof Bol) && !(b instanceof BolColore))
            return this.diametre==((Bol)b).diametre;
        else
            return b.equals(this);
    }
}