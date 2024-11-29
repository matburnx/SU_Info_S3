public class TestComplexe {
    public static void main(String[] args) {
        Complexe c1 = new Complexe(1,1);
        Complexe c2 = new Complexe(2,0);
        Complexe c3 = new Complexe(2,2);

        System.out.println(c2.estReel());
        System.out.println(c3.estReel());

        Complexe c4 = c1.addition(c2);
        System.out.println(c4.toString());

        Complexe c5 = c1.multiplication(c3);
        System.out.println(c5.toString());
    }
}
