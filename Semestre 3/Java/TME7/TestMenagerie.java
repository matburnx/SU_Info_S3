public class TestMenagerie {
    public static void main(String[] args) {
        Menagerie m = new Menagerie(10);
        Vache v1 = new Vache(3, "Marguerite");
        Boa b1 = new Boa(4, "Sam");

        m.ajouter(v1);
        m.ajouter(b1);

        System.out.println(m.toString());
        m.midi();
        m.vieillirTous();
        System.out.println(m.toString());
    }
}
