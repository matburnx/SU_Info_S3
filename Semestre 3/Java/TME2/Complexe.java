public class Complexe {
    double reelle, imag;

    public Complexe(double reelle, double imag) {
        this.reelle = reelle;
        this.imag = imag;
    }

    public Complexe() {
        this(Math.random()*(2+2)-2,Math.random()*(2+2)-2);
    }

    public String toString() {
        return "(" + reelle + " + " + imag + "i" + ")";
    }

    public boolean estReel() {
        return imag == 0.;
    }

    public Complexe addition(Complexe c2) {
        return new Complexe(this.reelle+c2.reelle,this.imag+c2.imag);
    }

    public Complexe multiplication(Complexe c2) {
        double reel = this.reelle * c2.reelle - this.imag * c2.imag;
        double im = this.reelle * c2.imag + this.imag * c2.reelle;
        return new Complexe(reel,im);
    }
}
