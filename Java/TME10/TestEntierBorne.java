public class TestEntierBorne {
    public static void main(String[] args) {
        try {
            EntierBorne ebX = new EntierBorne((int)(Math.random()*300-150));
            EntierBorne ebY = new EntierBorne((int)(Math.random()*2));
            System.out.println(ebX);
            System.out.println(ebY);

            EntierBorne somme = ebY.somme(ebX);
            System.out.println(somme);
            
            EntierBorne division = ebX.divPar(ebY);
            System.out.println(division);
        } catch (HorsBornesException e) {
            System.out.println(e);
        } catch (DivisionParZeroException divErr) {
            System.out.println(divErr);
        }
    }
}
