public class TestCone {
    public static void main(String[] args) {
        System.out.println(Cone.getNbCones());
        Cone c1 = new Cone(2.0,5.0);
        Cone c2 = new Cone();
        System.out.println(Cone.getNbCones());
    }
}
