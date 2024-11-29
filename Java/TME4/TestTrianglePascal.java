public class TestTrianglePascal {
    public static void main(String[] args) {
        TrianglePascal tr1 = new TrianglePascal(5);
        tr1.remplirTriangle();
        System.out.println(tr1.toString());

        TrianglePascal tr2 = new TrianglePascal(7);
        tr2.remplirTriangle();
        System.out.println(tr2.toString());

        TrianglePascal tr3 = new TrianglePascal(4);
        tr3.remplirTriangle();
        System.out.println(tr3.toString());
    }
}
