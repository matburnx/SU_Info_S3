public class TestVecteur {
    public static void main(String[] args) {
        Vecteur3D v1 = new Vecteur3D(1,2,3);
        Vecteur3D v2 = new Vecteur3D(3,2,1);

        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println((v1.somme(v2)).toString());
        System.out.println(Vecteur3D.somme(v1, v2).toString());
        
    }
}
