import java.util.Scanner;

public class TestSleep {
    public static void main(String[] args) {
        System.out.print( "Entrer un entier : " );
        Scanner scanner = new Scanner(System.in);
        int x=0;
        try {
            x = scanner.nextInt();
            System.out.println("Attente de "+x+" secondes");
            try {
                Thread.sleep(x*1000);
            } catch (InterruptedException i_e) {
                System.out.println(i_e);
            }
            System.out.println("Fin de l'attente");
        } catch (Exception e) {
            System.out.println("Le nombre est mal formé");
        }
        
    }
}
