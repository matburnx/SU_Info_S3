public class TestPersonne {
    public static void main(String[] args) {
        Personne p1 = new Personne("PersA");
        Personne p2 = new Personne("PersB");
        Personne p3 = new Personne("PersC");

        p1.epouser(p2);
        p1.epouser(p3);
        p3.epouser(p1);
        p3.epouser(p3);
        p1.divorcer();
        p3.divorcer();

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
}
