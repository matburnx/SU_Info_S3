public class Test {
    public static void main(String[] args) {
        System.out.println(Truc.getCpt());
        Truc n1 = new Truc();
        System.out.println(Truc.getCpt()+" "+n1.getNum());
        Truc n2 = new Truc(25);
        System.out.println(Truc.getCpt()+" "+n1.getNum()+" "+n2.getNum());
        Truc n3 = new Truc();
        System.out.println(Truc.getCpt()+" "+n1.getNum()+" "+n2.getNum()+" "+n3.getNum());

        Vecteur v1 = new Vecteur(1, 2), v2 = new Vecteur(1, 2);
        if(v1.x == v2.x && v1.y == v2.y)
            System.out.println("v1 egale v2");
        if(v1.getId() == v2.getId())
            System.out.println("Les points ont le même identifiant");
        
        System.out.println("Compteur (1): "+v1.getCpt2());
        System.out.println("Compteur (2): "+Vecteur.getCpt());        
    }
}