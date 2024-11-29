public class TestPile {
    public static void main(String[] args) {
        Pile p= new Pile(3);
        Assiette a1 = new Assiette(14);
        Assiette a2 = new Assiette();
        Assiette a3 = new Assiette(33);
        
        p.empiler(a1);
        p.empiler(a2);
        p.empiler(a3);
        System.out.println(p.toString());

        Assiette a4 = p.depiler();
        System.out.println("Depile :"+a4.toString());
        System.out.println(p.toString());

        Assiette a5 = new Assiette(12);
        Assiette a6 = new Assiette(35);
        p.empiler(a5);
        p.empiler(a6);
        System.out.println(p.toString());
        for(int i =0; i<4;i++) {
            p.depiler();
        }
        System.out.println("Apres avoir depile 4 fois :");
        System.out.println(p.toString());
    }
}
