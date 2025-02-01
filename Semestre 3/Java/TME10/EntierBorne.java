public class EntierBorne {
    private int n;
    public final static int MIN=-100;
    public final static int MAX=100;

    public EntierBorne(int n) throws HorsBornesException {
        if(n<MIN) {
            throw new HorsBornesException("Entier trop petit : "+n);
        } else if (n>MAX) {
            throw new HorsBornesException("Entier trop grand : "+n);
        } else {
            this.n=n;
        }
    }

    EntierBorne somme(EntierBorne eb) throws HorsBornesException {
        return new EntierBorne(this.n+eb.n);
    }

    EntierBorne divPar(EntierBorne eb) throws DivisionParZeroException, HorsBornesException {
        if(eb.n==0) {
            throw new DivisionParZeroException();
        } else {
            return new EntierBorne(this.n/eb.n);
        }
    }

    public String toString() {
        return String.format("%d", this.n);
    }
}
