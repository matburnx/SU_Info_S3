public class TestBol {
    public static void main(String[] args) {
        Bol b1 = new Bol(10);
        Bol b2 = new Bol(10);
        Object objB2=b2;

        BolColore bc1 = new BolColore(10, "gris");
        BolColore bc2 = new BolColore(10, "vert");

        System.out.println(b1==b2);
        System.out.println(b1.equals(b2));
        System.out.println(b1.equals(objB2));
        System.out.println(objB2.equals(b1));

        System.out.println(bc1.equals(bc2));
        System.out.println(bc1.equals(b1));
        System.out.println(b1.equals(bc1));
    }
}
