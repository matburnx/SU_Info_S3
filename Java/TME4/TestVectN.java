import java.util.Vector;

public class TestVectN {
    public static void main(String[] args) {
        VectN v1 = new VectN(1,2,3);
        VectN v2 = new VectN();
        VectN v3 = new VectN(4,20);

        System.out.println(v1.toString());
        System.out.println("Somme : "+v1.somme());
        System.out.println(v2.toString());
        System.out.println("Somme : "+v2.somme());
        System.out.println(v3.toString());
        System.out.println("Somme : "+v3.somme());

        VectN vect=new VectN(4,5,6);
        int[] t=vect.getTab();
        System.out.println("vect="+vect);
        t[0]=100;
        System.out.println("vect="+vect);
    }
}
