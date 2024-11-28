public class TestChien {
    public static void main(String[] args) {
        Chien c1 = new Chien();
        Mammifere m1 = c1;
        Chien c3 = (Chien) m1;
        ((Chien)m1).aboyer();
    }    
}
